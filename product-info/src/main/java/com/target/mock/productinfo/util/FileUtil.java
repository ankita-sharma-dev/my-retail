package com.target.mock.productinfo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static <T> T getObjectFromJsonFile(String filePath, TypeReference<T> typeRef){
        String json = readFile(filePath);
        T data = null;
        try {
            data = objectMapper.readValue(json, typeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return data;

    }
    private static String readFile(String filePath){
        ClassPathResource resource = new ClassPathResource(filePath);
        try(InputStream input = resource.getInputStream()){
            Scanner s = new Scanner(input).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";
            return result;
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
