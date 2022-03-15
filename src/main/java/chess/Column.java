package chess;

import java.util.Arrays;

public enum Column {

    A, B;

    public static Column of(final String value) {
        return Arrays.stream(values())
                .filter(it -> it.name().equalsIgnoreCase(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("'" + value + "'는 올바르지 않은 컬럼입니다."));
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
