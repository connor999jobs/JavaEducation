package com.knubisoft.tasks.algorithm.collection;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilesImpl implements FilesInterface {
    @Override
    public boolean contentEquals(File file1, File file2) throws IOException {
        if (file1.length() == file2.length()){
            List<String> list1 = Files.readAllLines(Path.of(file1.getPath()));
            List<String> list2 = Files.readAllLines(Path.of(file2.getPath()));
            return list1.equals(list2);
        }
        return false;
    }

    @Override
    public void copyDirectoryToDirectory(File sourceDir, File destinationDir) throws IOException {

    }

    @Override
    public String toString(URL url, Charset encoding) throws IOException {
        return null;
    }

    @Override
    public String toString(InputStream input, Charset charset) throws IOException {
        return null;
    }

    @Override
    public byte[] toByteArray(URL url) throws IOException {
        return new byte[0];
    }

    @Override
    public String normalize(String fileName) {
        return null;
    }

    @Override
    public List<String> readLines(File file, Charset charset) throws IOException {
        return null;
    }

    @Override
    public boolean isEmptyDirectory(File directory) {
        return false;
    }
}
