package chess;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "a1,a2", "a1,b1", "b1,b2",
            "A1,a2", "a1,B1", "B1,B2",
    })
    void create(final String moveCommand) {
        assertDoesNotThrow(() -> MoveCommand.of(moveCommand));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "a1a2", "a1,b3", "b1 ,b2", "a1,b3 "
    })
    void invalid(final String moveCommand) {
        assertThrows(IllegalArgumentException.class, () -> MoveCommand.of(moveCommand));
    }
}
