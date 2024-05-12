package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    public void required() {
        Predicate<String> rule = input -> !(input == null || input.isEmpty());
        addValidation("required", rule);
    }

    public void minLength(int value) {
        Predicate<String> rule = input -> {
            return input == null ? true : input.length() > value;
        };
        addValidation("minLength", rule);
    }

    public void contains(String value) {
        Predicate<String> rule = input -> input == null ? false : input.contains(value);
        addValidation("contains", rule);
    }
}
