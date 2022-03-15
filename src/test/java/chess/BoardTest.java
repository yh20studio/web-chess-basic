package chess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void move() {
        final var board = Board.create();

        board.move(MoveCommand.of("a1,a2"));

        assertThat(board.toMap()).hasSize(3);
    }

    @Test
    void moveNotExists() {
        final var board = Board.create();
        final var moveCommand = MoveCommand.of("a1,a2");
        board.move(moveCommand);

        assertThrows(NoSuchElementException.class, () -> board.move(moveCommand));
    }
}
