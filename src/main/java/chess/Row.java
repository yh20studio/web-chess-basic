package chess;

import java.util.Arrays;

public enum Row {

    ONE(1), TWO(2),

    ;

    private final int value;

    Row(final int value) {
        this.value = value;
    }

    public static Row of(final String value) {
        return of(Integer.parseInt(value));
    }

    public static Row of(final int value) {
        return Arrays.stream(values())
                .filter(it -> it.value == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("'" + value + "'는 올바르지 않은 로우입니다."));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
