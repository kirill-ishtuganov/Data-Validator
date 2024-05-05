package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    private Predicate<String> isFilled;
    private Predicate<String> isLongEnough;
    private Predicate<String> isContainsSubstring;

    public StringSchema() {
        isFilled = input -> true;
        isLongEnough = input -> true;
        isContainsSubstring = input -> true;
    }

    public void required() {
        isFilled = input -> !(input == null || input.isEmpty());
    }

    public void minLength(int value) {
        isLongEnough = input -> {
            return input == null ? true : input.length() > value;
        };
    }

    public void contains(String value) {
        isContainsSubstring = input -> input.contains(value);
    }
}
