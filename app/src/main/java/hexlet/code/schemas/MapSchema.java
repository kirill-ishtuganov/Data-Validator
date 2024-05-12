package hexlet.code.schemas;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema<L, T> extends BaseSchema<Map<L, T>> {

    public void required() {
        Predicate<Map<L, T>> rule = input -> !(input == null);
        addValidation("required", rule);
    }

    public void sizeof(int value) {
        Predicate<Map<L, T>> rule = input -> input.size() == value;
        addValidation("sizeof", rule);
    }

    public void shape(Map<L, BaseSchema<T>> schemas) {

        Predicate<Map<L, T>> rule = input -> {
            List<Boolean> results = input.entrySet().stream()
                    .map(entry -> {
                        var key = entry.getKey();
                        var value = entry.getValue();
                        return schemas.get(key).isValid(value);
                    })
                    .toList();
            return !results.contains(false);
        };
        addValidation("shape", rule);
    }
}
