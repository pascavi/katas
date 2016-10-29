package org.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pascual on 28/10/2016.
 */
class Game {

    private int[][] cells;

    /**
     * Game rule, a cell should survive only if it has 2 or 3 neighbours
     * @param numberOfNeighbours
     * @return boolean
     */
    boolean cellShouldSurvive(int numberOfNeighbours) {
        if (numberOfNeighbours == 2 || numberOfNeighbours == 3) {
            return true;
        }
        return false;
    }

    /**
     * Given a position(coordinates) of the plane it returns its 8 adjacents points
     * @param position
     * @return
     */
    int[][] getPositionNeighbourhood(int[] position) {
        int[][] neighbours = new int[8][];
        int c = 0;
        for (int j = -1; j <= 1; j++) {
            for (int i = -1; i <= 1; i++) {
                if (j == 0 && i == 0) continue;
                int[] neighbour = {position[0] + i, position[1] + j};
                neighbours[c++] = neighbour;
            }
        }
        return neighbours;
    }

    /**
     * Given a position(coordinates) it calculates how many cells are in adjacent positions
     * @param position
     * @return
     */
    int calculateNeighboursForPosition(int[] position) {
        int[][] neighbourhood = getPositionNeighbourhood(position);
        int total = 0;
        for (int[] coordinate : neighbourhood) {
            if (cellExists(coordinate)) total++;
        }
        return total;
    }

    /**
     * Game Rule, a position should reproduce a new cell if surrounded of 3 neighbours
     * @param position
     * @return
     */
    boolean shouldPositionReproduce(int[] position) {
        int total = calculateNeighboursForPosition(position);
        return total>=3;
    }

    /**
     * Calculates surviving cells according to underpopulation and overcrowding rules
     * @return
     */
    int[][] getSurvivingCells() {
        ArrayList<int[]> survivingCells = new ArrayList<>();
        for(int[] cell:cells){ //go through current alive cells
            if(cellShouldSurvive(calculateNeighboursForPosition(cell))) survivingCells.add(cell);
        }
        int[][] survivingCellsArray = survivingCells.toArray(new int[survivingCells.size()][2]);
        return survivingCellsArray;
    }

    /**
     * Calculates new reproduced cells according to reproduction rule
     * If provided list of cells surviving to next gen, it avoids duplications
     * @param survivingCells (optional)
     * @return
     */
    int[][] getNewCells(List<int[]> survivingCells) {
        ArrayList<int[]> newCells = new ArrayList<>();
        for(int[] cell:cells){ //go through current alive cells
            int[][] neighbourhood = getPositionNeighbourhood(cell);
            for(int[] coordinate:neighbourhood){ //for each cell check the neighbour positions
                if(cellExists(newCells,coordinate))
                    continue; //this position already has a new cell
                if(survivingCells!=null && cellExists(survivingCells,coordinate))
                    continue; //surviving cells for next generation were provided and there is a cell in this position
                if(shouldPositionReproduce(coordinate)) newCells.add(coordinate);
            }
        }
        int[][] newCellsArray = newCells.toArray(new int[newCells.size()][2]);
        return newCellsArray;
    }

    int[][] getNewCells() {
        return getNewCells(null);
    }

    /**
     * Calculates next generation
     * @return
     */
    int[][] getNextGeneration(){
        ArrayList<int[]> survivingCells= new ArrayList(Arrays.asList(getSurvivingCells()));
        List<int[]> newCells = Arrays.asList(getNewCells(survivingCells));
        survivingCells.addAll(newCells);

        int[][] cellsArray = survivingCells.toArray(new int[survivingCells.size()][2]);
        return cellsArray;
    }

    /**
     * Auxiliar, given an array of positions, it checks if there is a cell in a certain position
     * @param position
     * @return
     */
    boolean cellExists(List<int[]> cells,int[] position){
        for(int[] cell:cells){
            if(Arrays.equals(cell,position)) return true;
        }
        return false;
    }

    boolean cellExists(int[] position){
        return cellExists(Arrays.asList(cells),position);
    }

    void setCells(int[][] cells) {
        this.cells = cells;
    }
}
