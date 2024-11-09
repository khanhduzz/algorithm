package com.khanhduzz.algorithm.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSONData {
    /**
     * Read the data from json file, where has big data
     * @param filePath
     * @return array
     * @throws IOException
     */
    public static int[] readLargeArrayFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, int[].class);
    }
}
