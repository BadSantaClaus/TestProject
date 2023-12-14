package org.example.interview;

import com.networknt.schema.JsonValidator;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Objects;

public class JsonSchemaValidation {

    public static void main(String[] args) {
        JSONObject jsonSchema = new JSONObject(new JSONTokener(
                Objects.requireNonNull(JsonValidator.class.getResourceAsStream("/schema.json"))));
        JSONObject jsonData = new JSONObject(new JSONTokener(
                Objects.requireNonNull(JsonValidator.class.getResourceAsStream("/data.json"))));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonData);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}
