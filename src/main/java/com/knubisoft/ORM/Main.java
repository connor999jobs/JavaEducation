package com.knubisoft.ORM;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileContentTypeEnum type1 = FileContentTypeEnum.CSV;
        FileContentTypeEnum type2 = FileContentTypeEnum.JSON;
        FileContentTypeEnum type3 = FileContentTypeEnum.XML;


        File file1 = new File("MOCK_DATA.csv");
        File file2 = new File("MOCK_DATA.json");
        File file3 = new File("dataset.xml");

//        List<Person> personList = CSVOrm.transform(lines, Person.class);
//        List<Person2> person2List = CSVOrm.transform(lines, Person2.class);

        List<Person> personList = CSVOrm.transform(file2, Person.class);
        List<Person2> person2List1 = CSVOrm.transform(file2, Person2.class);
        List<Person> personList1 = CSVOrm.transform(file1, Person.class);
        List<Person> personList2 = CSVOrm.transform(file3, Person.class);
        List<Person2> person2List2 = CSVOrm.transform(file3, Person2.class);
    }
}
