package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    @Override
    public final StringSchema required() {
        addValidation("required", input -> !(input == null || input.isEmpty()));
        return this;
    }

    public final StringSchema minLength(int value) {
        addValidation("minLength", input -> input == null || input.length() > value);
        return this;
    }

    public final StringSchema contains(String value) {
        addValidation("contains", input -> input == null || input.contains(value));
        return this;
    }
}
