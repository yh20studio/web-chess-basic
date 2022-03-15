package chess;

import java.util.Objects;

public final class Position {

    private final Column column;

    private final Row row;

    private Position(final Column column,
                     final Row row) {
        this.column = column;
        this.row = row;
    }

    public static Position of(final String value) {
        final var column = Column.of(value.substring(0, 1));
        final var row = Row.of(value.substring(1));

        return new Position(column, row);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position = (Position) o;
        return column == position.column && row == position.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    @Override
    public String toString() {
        return column.toString() + row.toString();
    }
}
