package org.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameOfLifeTest {
    Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void zero_neighbours_shouldnt_survive(){
        assertThat(game.cellShouldSurvive(0), is(false));
    }

    @Test
    public void one_neighbours_shouldnt_survive(){
        assertThat(game.cellShouldSurvive(1), is(false));
    }

    @Test
    public void two_neighbours_shouldn_survive(){
        assertThat(game.cellShouldSurvive(2), is(true));
    }

    @Test
    public void four_neighbours_shouldnt_survive(){
        assertThat(game.cellShouldSurvive(4), is(false));
    }

    @Test
    public void neighbourhood_coordinates_for_a_position_are_correctly_calculated(){
        Game game = new Game();
        int[] position = {0,0};
        int[][] expectedCoordinates = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
        assertThat(Arrays.deepEquals(game.getPositionNeighbourhood(position), expectedCoordinates), is(true));
    }

    @Test
    public void one_cell_in_the_neighbourhood_makes_a_total_of_one_neighbour(){
        Game game = new Game();
        int cells[][] = {{1,1}};
        game.setCells(cells);
        int[] position = {0,0};
        assertThat(game.calculateNeighboursForPosition(position), is(1));
    }

    @Test
    public void three_cells_in_the_neighbourhood_makes_a_total_of_three_neighbours(){
        Game game = new Game();
        int cells[][] = {{0,1},{1,0},{1,1}};
        game.setCells(cells);
        int[] position = {0,0};
        assertThat(game.calculateNeighboursForPosition(position), is(3));
    }

    @Test
    public void two_neighbours_shouldnt_reproduce(){
        int cells[][] = {{0,1},{1,0}};
        game.setCells(cells);
        int[] position = {0,0};
        assertThat(game.shouldPositionReproduce(position), is(false));
    }

    @Test
    public void three_neighbours_should_reproduce(){
        int cells[][] = {{0,1},{1,0},{1,1}};
        game.setCells(cells);
        int[] position = {0,0};
        assertThat(game.shouldPositionReproduce(position), is(true));
    }

    /**
     *    · X ·         · X ·
     *    X · X    =>   X X X
     *    · X ·         · X ·
     */
    @Test
    public void example_setup_kills_just_central_cell(){
        int cells[][] = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};
        game.setCells(cells);
        int survivingCells[][] = game.getSurvivingCells();
        int[][] expected = {{-1,0},{1,0},{0,1},{0,-1}};
        assertThat(Arrays.deepEquals(survivingCells,expected), is(true));
    }

    /**
     *    · X ·         · X ·
     *    X · X    =>   X X X
     *    · X ·         · X ·
     */
    @Test
    public void example_setup_reproduces_just_central_cell(){
        int[][] cells = {{-1,0},{1,0},{0,1},{0,-1}};
        game.setCells(cells);
        int newCells[][] = game.getNewCells();
        int[][] expected = {{0,0}};
        assertThat(Arrays.deepEquals(newCells,expected), is(true));
    }

    /**
     *  Calculating a full next generation
     *
     *    · · ·         · X ·         · · ·
     *    X X X    =>   · X ·   =>    X X X
     *    · · ·         · X ·         · · ·
     */
    @Test
    public void blinker_period_2_step_1_nextgen(){
        int[][] cells = {{-1,0},{0,0},{1,0}};
        game.setCells(cells);
        int nextGen[][] = game.getNextGeneration();
        int[][] expected = {{0,0},{0,1},{0,-1}};
        assertThat(haveSameCells(nextGen,expected), is(true));
    }

    @Test
    public void blinker_period_2_step_2_nextgen(){
        int[][] cells = {{0,0},{0,1},{0,-1}};
        game.setCells(cells);
        int nextGen[][] = game.getNextGeneration();
        int[][] expected = {{-1,0},{0,0},{1,0}};
        assertThat(haveSameCells(nextGen,expected), is(true));
    }

    /**
     * Auxiliary, compare two lists of coordinates
     * @param set1
     * @param set2
     * @return
     *
     */
    boolean haveSameCells(int[][] set1,int[][] set2){
        List<int[]> list1= Arrays.asList(set1);
        List<int[]> list2= Arrays.asList(set2);
        if(list1.size()!=list2.size()) return false;
        for(int[] cell:list1){
            if(!game.cellExists(list2,cell)) return false;
        }
        return true;
    }



}
