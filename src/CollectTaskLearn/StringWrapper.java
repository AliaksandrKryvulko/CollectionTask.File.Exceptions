package CollectTaskLearn;

import java.util.Objects;

public class StringWrapper  {
private String value;

    public StringWrapper(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringWrapper)) return false;
        StringWrapper that = (StringWrapper) o;
        return Objects.equals(getValue().toUpperCase(), that.getValue().toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue().toUpperCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value ;
    }
}
