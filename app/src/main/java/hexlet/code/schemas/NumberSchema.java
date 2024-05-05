package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    private Predicate<Integer> isFilled;
    private Predicate<Integer> isPositive;
    private Predicate<Integer> isInRange;

    public NumberSchema() {
        isFilled = input -> true;
        isPositive = input -> true;
        isInRange = input -> true;
    }

    public void required() {
        isFilled = input -> !(input == null);
    }

    public void positive() {
        isPositive = input -> input > 0;
    }

    public void range(int min, int max) {
        isInRange = input -> min <= input && input <= max;
    }
}
