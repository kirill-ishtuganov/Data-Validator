package hexlet.code.schemas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private final Map<String, Predicate<T>> rules;

    public BaseSchema() {
        this.rules = new HashMap<>();
        Predicate<T> rule = input -> true;
        rules.put("init", rule);
    }

    public final void addValidation(String ruleName, Predicate<T> rule) {
        rules.put(ruleName, rule);
    }

    public final boolean isValid(T value) {

        List<Boolean> results = rules.values().stream()
                .map(rule -> rule.test(value))
                .toList();
        return !results.contains(false);
    }
}
