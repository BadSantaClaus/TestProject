package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.annotation.ExportTest2;
import org.junit.jupiter.api.Test;

@ExportTest2(name = "annotated class")
public class SimpleTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test() throws JsonProcessingException {
        String invalidJson = "{ \"name\": \"John Doe\", \"age\": 30, \"city\": \"New York\"}"; // Невалидный JSON с лишней запятой
        JsonNode jsonNode = objectMapper.readTree(invalidJson);
        System.out.println(jsonNode.get("name").toString());
    }
}
