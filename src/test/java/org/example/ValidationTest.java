package org.example;

import com.networknt.schema.JsonValidator;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ValidationTest {

    @Test
    public void test1() {

        JSONObject jsonSchema = new JSONObject(new JSONTokener(
                Objects.requireNonNull(JsonValidator.class.getResourceAsStream("/schema.json"))));
        JSONObject jsonData = new JSONObject(new JSONTokener(
                Objects.requireNonNull(JsonValidator.class.getResourceAsStream("/data.json"))));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonData);
        } catch (ValidationException e) {
            System.out.println("schema validation failed");
            e.printStackTrace();
        }
        System.out.println("schema validated successfully");
    }
}
