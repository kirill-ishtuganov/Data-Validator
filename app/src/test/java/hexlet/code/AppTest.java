package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public final void testStringSchema() {

        var schema = new Validator().string();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("Hello"));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        schema.contains("He");
        assertFalse(schema.isValid("ello"));
        assertTrue(schema.isValid("Hello"));
        schema.minLength(3);
        assertFalse(schema.isValid("He"));
        assertTrue(schema.isValid("Hello"));
    }

    @Test
    public final void testNumberSchema() {

        var schema = new Validator().number();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(-5));
        assertTrue(schema.isValid(23));
        assertTrue(schema.isValid(0));
        schema.required();
        assertFalse(schema.isValid(null));
        schema.positive();
        assertFalse(schema.isValid(-2));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(6));
        schema.inRange(4, 10);
        assertFalse(schema.isValid(2));
        assertFalse(schema.isValid(11));
        assertTrue(schema.isValid(10));

    }

    @Test
    public final void testMapSchema() {

        var schema = new Validator().map();
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(data));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        assertTrue(schema.isValid(data));
        schema.sizeOf(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public final void testMapSchemaShape() {

        var v = new Validator();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        var firstNameSchema = v.string();
        firstNameSchema.required();
        schemas.put("firstName", firstNameSchema);

        var lastNameSchema = v.string();
        lastNameSchema.required();
        lastNameSchema.minLength(2);
        schemas.put("lastName", lastNameSchema);

        var schema = v.map();
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));
    }
}
