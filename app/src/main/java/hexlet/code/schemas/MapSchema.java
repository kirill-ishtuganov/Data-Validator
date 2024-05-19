package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema<L, T> extends BaseSchema<Map<L, T>> {

    public final MapSchema<L, T> sizeof(int value) {
        addValidation("sizeof", input -> input == null || input.size() == value);
        return this;
    }

    public final MapSchema<L, T> shape(Map<L, BaseSchema<T>> schemas) {

        Predicate<Map<L, T>> rule = input -> {
            if (input == null) {
                return true;
            }
            return input.entrySet().stream()
                    .allMatch(entry -> {
                        var key = entry.getKey();
                        var value = entry.getValue();
                        return schemas.get(key).isValid(value);
                    });
        };
        addValidation("shape", rule);
        return this;
    }
}
