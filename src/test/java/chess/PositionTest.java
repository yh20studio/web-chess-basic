package chess;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "a1", "a2", "b1", "b2"
    })
    void create(final String position) {
        assertDoesNotThrow(() -> Position.of(position));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "a3", "c1", "b0", "a", "aa", "a12"
    })
    void invalid(final String position) {
        assertThrows(IllegalArgumentException.class, () -> Position.of(position));
    }
}