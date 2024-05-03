package hexlet.code.schemas;

public class StringSchema extends Schema {

    private boolean mustBeFilled;
    private Integer minLength;
    private String substring;

    public StringSchema() {
        mustBeFilled = false;
        minLength = null;
        substring = null;
    }

    public void required() {
        mustBeFilled = true;
    }

    public void minLength(int value) {
        minLength = value;
    }

    public void contains(String value) {
        substring = value;
    }

    public boolean isValid(String value) {

        if (mustBeFilled && (value == null || value == "")) {
            return false;
        } else if (minLength != null && value.length() < minLength) {
            return false;
        } else if (substring != null && !value.contains(substring)) {
            return false;
        }
        return true;
    }
}
