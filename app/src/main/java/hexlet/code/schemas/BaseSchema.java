package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private final Map<String, Predicate<T>> rules;

    public BaseSchema() {
        this.rules = new HashMap<>();
    }

    protected final void addValidation(String ruleName, Predicate<T> rule) {
        rules.put(ruleName, rule);
    }

    public BaseSchema<T> required() {
        addValidation("required", Objects::nonNull);
        return this;
    }

    public final boolean isValid(T value) {
        return rules.values().stream()
                .allMatch(rule -> rule.test(value));
    }
}
