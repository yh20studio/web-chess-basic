package chess;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public final class Board {

    private final Map<Position, Piece> value;

    private Board(final Map<Position, Piece> value) {
        this.value = value;
    }

    public static Board create() {
        final var value = new HashMap<Position, Piece>(4);

        value.put(Position.of("a1"), new Piece(Color.WHITE));
        value.put(Position.of("a2"), new Piece(Color.BLACK));
        value.put(Position.of("b1"), new Piece(Color.BLACK));
        value.put(Position.of("b2"), new Piece(Color.WHITE));

        return new Board(value);
    }

    public void move(final MoveCommand moveCommand) {
        final var piece = value.remove(moveCommand.from());
        if (isNull(piece)) {
            throw new NoSuchElementException("'" + moveCommand.from() + "' 위치에 체스말이 없습니다.");
        }

        value.put(moveCommand.to(), piece);
    }

    public Map<Position, Piece> toMap() {
        return new HashMap<>(value);
    }
}
