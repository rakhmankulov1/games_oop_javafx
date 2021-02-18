package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, FigureNotFoundException, OccupiedCellException {
        boolean rsl = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(dest);
            free(steps);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rsl = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rsl;
    }



    private boolean free(Cell[] steps) throws OccupiedCellException {
       for (Figure figure : figures) {
            for (Cell cell : steps) {
                if (figure.position().equals(cell)) {
                    throw new OccupiedCellException("ячейка занята");
                }
            }
        }
        return false;
    }
       /* boolean free = true;
        for(Cell step : steps){
            for(Figure figure : figures) {
                if(figure!=null && step.equals(figure.position())){
                    free = false;
                }
            }
        }
        return free;
    }*/

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException("фигуры нет на клетке.");
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
