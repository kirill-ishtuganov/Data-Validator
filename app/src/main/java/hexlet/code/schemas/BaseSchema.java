package hexlet.code.schemas;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {

    public boolean isValid(T value) {

        List<Field> fields = List.of(this.getClass().getDeclaredFields());
        List<Boolean> results = fields.stream()
                .map(field ->  {
                    Predicate<T> result;
                    try {
                        field.setAccessible(true);
                        result = (Predicate<T>) field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    return result.test(value);
                })
                .toList();
        return !results.contains(false);
    }
}
