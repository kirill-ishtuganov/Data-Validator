package hexlet.code.schemas;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema<L, R> extends BaseSchema {

    private Predicate<Map<L, R>> isFilled;
    private Predicate<Map<L, R>> isInRightSize;
    private Predicate<Map<L, BaseSchema<R>>> isMatchesThePattern;

    public MapSchema() {
        isFilled = input -> true;
        isInRightSize = input -> true;
        isMatchesThePattern = input -> true;
    }

    public void required() {
        isFilled = input -> !(input == null);
    }

    public void sizeof(int value) {
        isInRightSize = input -> input.size() == value;
    }

    public void shape(Map<L, BaseSchema<R>> schemas) {

        isMatchesThePattern = input -> {
            var inputEntries = input.entrySet();
            List<Boolean> results = inputEntries.stream()
                    .map(entry -> {
                        var key = entry.getKey();
                        var value = (R) entry.getValue();
                        return schemas.containsKey(key) && schemas.get(key).isValid(value);
                    })
                    .toList();
            return !results.contains(false);
        };
    }
}
