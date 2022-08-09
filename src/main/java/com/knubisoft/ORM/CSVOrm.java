package com.knubisoft.ORM;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVOrm {
    public static final String DELIMITER = ",";
    public static final String COMMENT = "--";

    public static <T> List<T> transform(File file, Class<T> cls) throws IOException {
        FileContentTypeEnum type;
        if (file.getName().endsWith(".csv")){
            type = FileContentTypeEnum.CSV;
        }else if (file.getName().endsWith(".json")){
            type = FileContentTypeEnum.JSON;
        }else if (file.getName().endsWith(".xml")){
            type = FileContentTypeEnum.XML;
        }else {
            throw new IllegalArgumentException();
        }
        Path pathDir = FileSystems.getDefault().getPath("").toAbsolutePath();
        String path = (pathDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + file.getName());
        if (type.equals(FileContentTypeEnum.CSV)) {
            InputStream stream = Main.class.getClassLoader().getResourceAsStream(file.getName());
            assert stream != null;
            List<String> lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);
            Map<Integer, String> mapping = buildMapping(lines.get(0));
            return lines.subList(1, lines.size()).stream().map(line -> toType(line, cls, mapping))
                    .collect(Collectors.toList());
        } else if (type.equals(FileContentTypeEnum.JSON)) {

            String json = readToString(pathDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + file.getName());
            List<Object> list = jsonToList(json, cls);
            return (List<T>) list;

        }else if(type.equals(FileContentTypeEnum.XML)) {
            String xml = readToString(path);
            xml = xml.replaceAll("</record>", "<record>");
            String[] arr = xml.split("<record>");
            List<Object> result = new ArrayList<>();
            for (int i = 1; i< arr.length; i +=2){
                result.add(xmlToType(arr[i],cls));
            }
            return (List<T>) result;
        }

        throw new IllegalArgumentException();
    }

    private static <T> T xmlToType(String line, Class<T> cls) {
        Map map = new LinkedHashMap();
        String[] str = line.split("><");
        T type = null;
        try {
            type = cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String s : str) {
            if (s.startsWith("<")) {
                s = s.replaceFirst("<", "");
            }
            if (s.endsWith(">")) {
                s = s.substring(0, s.length());
            }
            int find1 = s.indexOf(">");
            int find2 = s.substring(find1).indexOf("<");
            String value = s.substring(find1 + 1, find2 + find1);
            String field = s.substring(0, find1);
            setValueIntoFieldOrThrow(value.trim(),field.trim(),type);
        }
        return type;
    }

    private static Map<Integer, String> buildMapping(String firstLine) {
        Map<Integer, String> map = new LinkedHashMap<>();
        String[] array = splitLine(firstLine);
        for (int index = 0; index < array.length; index++) {
            String value = array[index];
            if (value.contains(COMMENT)) {
                value = value.split(COMMENT)[0];
            }
            map.put(index, value.trim());
        }
        return map;
    }

    private static List<Object> jsonToList(String strJson, Class<?> cls) {
        List<Object> result = new ArrayList<>();
        Gson gson = new Gson();
        Map[] map = gson.fromJson(strJson, Map[].class);
        for (Map m : map) {
            Object o = setIntoFieldForJson(m, cls);
            result.add(o);
        }
        return result;
    }

    private static <T> T setIntoFieldForJson(Map map, Class<T> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        T type = null;
        try {
            String s = map.toString();
            type = cls.getDeclaredConstructor().newInstance();
            s = s.replaceAll("\\{", "");
            s = s.replaceAll("\\}", "");
            String[] str = splitLine(s);
            for (int i = 0; i < str.length; i++) {
                int index = str[i].indexOf("=");
                String fieldName = str[i].substring(0, index);
                String value = str[i].substring(index + 1);
                int dot = value.indexOf(".");
                if (value.contains(".")) {
                    value = value.substring(0, dot);
                }
                setValueIntoFieldOrThrow(value.trim(), fieldName.trim(), type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type;
    }

    @SneakyThrows
    private static <T> T toType(String line, Class<T> cls, Map<Integer, String> mapping) {
        T type = cls.getDeclaredConstructor().newInstance();

        String[] array = splitLine(line);
        for (int index = 0; index < array.length; index++) {
            String value = array[index];
            String fieldName = mapping.get(index);
            setValueIntoFieldOrThrow(value, fieldName, type);
        }

        return type;
    }

    private static void setValueIntoFieldOrThrow(String value, String fieldName, Object type) {
        try {
            Field field = type.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(type, transformValueToFieldType(field, value));
        } catch (NoSuchFieldException noField) {
            // ignore
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object transformValueToFieldType(Field field, String value) {
        Map<Class<?>, Function<String, Object>> typeToFunction = new LinkedHashMap<>();
        typeToFunction.put(String.class, s -> s);
        typeToFunction.put(int.class, Integer::parseInt);
        typeToFunction.put(Float.class, Float::parseFloat);
        typeToFunction.put(LocalDate.class, LocalDate::parse);
        typeToFunction.put(LocalDateTime.class, LocalDate::parse);
        typeToFunction.put(Long.class, Long::parseLong);
        typeToFunction.put(BigInteger.class, BigInteger::new);
        typeToFunction.put(double.class, Double::parseDouble);

        return typeToFunction.getOrDefault(field.getType(), type -> {
            throw new UnsupportedOperationException("Type is not supported by parser " + type);
        }).apply(value);
    }

    private static String[] splitLine(String line) {
        return line.split(DELIMITER);
    }

    private static String readToString(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}

enum FileContentTypeEnum {
    CSV,
    XML,
    JSON
}
