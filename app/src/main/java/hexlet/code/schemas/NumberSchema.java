package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public void required() {
        Predicate<Integer> rule = input -> !(input == null);
        addValidation("required", rule);
    }

    public void positive() {
        Predicate<Integer> rule = input -> input > 0;
        addValidation("positive", rule);
    }

    public void range(int min, int max) {
        Predicate<Integer> rule = input -> min <= input && input <= max;
        addValidation("range", rule);
    }
}
