package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest extends TestCase {

    @Test
    public void testWhenPositionThenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position(), equalTo(Cell.findBy(2, 7)));
    }

    @Test
    public void testWhenWayWork() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.B2, Cell.A3};
        assertThat(bishopBlack.way(Cell.A3), is(expected));
    }

    @Test
    public void testWhenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C7);
        boolean expected = bishopBlack.isDiagonal(Cell.C7, Cell.B6);
        assertEquals(expected, (true));
    }

    @Test
    public void testWhenCopyWork() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C7);
        assertThat(bishopBlack.copy(Cell.C7).position(), equalTo(Cell.C7));
    }
}