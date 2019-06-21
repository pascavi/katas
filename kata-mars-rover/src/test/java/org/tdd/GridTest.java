package org.tdd;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {
    private static final int[] NORTH = {0,1};
    private static final int[] EAST = {1,0};
    private static final int[] SOUTH = {0,-1};
    private static final int[] WEST = {-1,0};

    @Test
    public void new_heading_angle_is_correctly_calculated() {
        Assert.assertEquals("Angles should be additive",
                90, Grid.getRotatedHeadingAngle(0,90));
        Assert.assertEquals("Reduce to the equivalent under 360",
                90, Grid.getRotatedHeadingAngle(270,180));
        Assert.assertEquals("Only multiple of 90 as new angles",
                270, Grid.getRotatedHeadingAngle(270,5));
        Assert.assertEquals("Take equivalent positive angle",
                270, Grid.getRotatedHeadingAngle(0,-90));
    }

    @Test
    public void movement_vector_is_correctly_calculated_from_current_heading_vector_and_longitude() {
        Assert.assertArrayEquals("move east for 0",EAST, Grid.getMovement(0,1));
        Assert.assertArrayEquals("move north for 90",NORTH,Grid.getMovement(90,1));
        Assert.assertArrayEquals("move west for 180",WEST, Grid.getMovement(180,1));
        Assert.assertArrayEquals("move south for 270",SOUTH, Grid.getMovement(270,1));

        Assert.assertArrayEquals("move south for heading 90 and longitude -1",SOUTH, Grid.getMovement(90,-1));
        int[] northX2 = {0,2};
        Assert.assertArrayEquals("move 2 to north: heading 90, longitude 2",northX2, Grid.getMovement(90,2));
    }

    @Test
    public void new_position_is_calculated_from_current_position_and_movement() {
        int n = 3;
        Grid grid = new Grid(n);
        int[][][] coords = getCoordsMatrix(n);

        Assert.assertArrayEquals("New position without hitting a border",
                coords[0][1], grid.getNewPosition(coords[0][0],NORTH));
        Assert.assertArrayEquals("New position from the northern border",
                coords[0][0], grid.getNewPosition(coords[0][2],NORTH));
        Assert.assertArrayEquals("New position from the southern border",
                coords[0][2], grid.getNewPosition(coords[0][0],SOUTH));
        Assert.assertArrayEquals("New position from the eastern border",
                coords[0][0], grid.getNewPosition(coords[2][0],EAST));
        Assert.assertArrayEquals("New position from the western border",
                coords[2][0], grid.getNewPosition(coords[0][0],WEST));
        int[] jumpBack = {0,-7};
        Assert.assertArrayEquals("Big jump back",
                coords[0][2], grid.getNewPosition(coords[0][0],jumpBack));
    }

    private int[][][] getCoordsMatrix(int n){
        int[][][] coords = new int[n][n][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                int[] coord = {i,j};
                coords[i][j] = coord;
            }
        return coords;
    }

}
