package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        Predicate<Integer> rule = input -> !(input == null);
        addValidation("required", rule);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Integer> rule = input -> input == null ? true :  input > 0;
        addValidation("positive", rule);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        Predicate<Integer> rule = input -> input == null ? false : min <= input && input <= max;
        addValidation("range", rule);
        return this;
    }
}
