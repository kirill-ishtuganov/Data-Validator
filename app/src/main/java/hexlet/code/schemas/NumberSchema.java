package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        Predicate<Integer> rule = input -> !(input == null);
        addValidation("required", rule);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> rule = input -> input > 0;
        addValidation("positive", rule);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Integer> rule = input -> min <= input && input <= max;
        addValidation("range", rule);
        return this;
    }
}
