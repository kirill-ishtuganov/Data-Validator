package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        Predicate<String> rule = input -> !(input == null || input.isEmpty());
        addValidation("required", rule);
        return this;
    }

    public StringSchema minLength(int value) {
        Predicate<String> rule = input -> input == null ? true : input.length() > value;
        addValidation("minLength", rule);
        return this;
    }

    public StringSchema contains(String value) {
        Predicate<String> rule = input -> input == null ? false : input.contains(value);
        addValidation("contains", rule);
        return this;
    }
}
