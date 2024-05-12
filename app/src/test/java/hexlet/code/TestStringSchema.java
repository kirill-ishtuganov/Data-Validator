package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStringSchema {

    @Test
    public final void testRequired() {

        var schema = new Validator().string();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("Hello"));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    public final void testContains() {

        var schema = new Validator().string();
        assertTrue(schema.isValid("ello"));
        schema.contains("He");
        assertFalse(schema.isValid("ello"));
        assertTrue(schema.isValid("Hello"));
    }

    @Test
    public final void testMinLength() {

        var schema = new Validator().string();
        assertTrue(schema.isValid("Hello"));
        schema.minLength(3);
        assertFalse(schema.isValid("He"));
        assertTrue(schema.isValid("Hello"));
    }
}
