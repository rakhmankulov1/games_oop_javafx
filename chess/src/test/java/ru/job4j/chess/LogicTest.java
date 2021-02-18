package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.QueenWhite;



public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveErrFindBy() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C4));
        logic.move(Cell.F2, Cell.D4);
    }

    @Test(expected = IllegalStateException.class)
    public void whenMoveErrWay() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1,Cell.E4);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveErrFree() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new QueenWhite(Cell.E3));
        logic.move(Cell.C1, Cell.G5);
    }


}