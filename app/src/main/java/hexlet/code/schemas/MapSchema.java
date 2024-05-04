package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema<L, R> extends BaseSchema {

    private Predicate<Map<L, R>> isFilled;
    private Predicate<Map<L, R>> isInRightSize;

    public MapSchema() {
        isFilled = input -> true;
        isInRightSize = input -> true;
    }

    public void required() {
        isFilled = input -> !(input == null);
    }

    public void sizeOf(int value) {
        isInRightSize = input -> input.size() == value;
    }
}
