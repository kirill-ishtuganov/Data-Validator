package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNumberSchema {

    @Test
    public final void testRequired() {

        var schema = new Validator().number();
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    public final void testPositive() {

        var schema = new Validator().number();
        assertTrue(schema.isValid(-2));
        schema.positive();
        assertFalse(schema.isValid(-2));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(6));
    }

    @Test
    public final void testRange() {

        var schema = new Validator().number();
        schema.range(4, 10);
        assertFalse(schema.isValid(2));
        assertFalse(schema.isValid(11));
        assertTrue(schema.isValid(10));
    }
}
