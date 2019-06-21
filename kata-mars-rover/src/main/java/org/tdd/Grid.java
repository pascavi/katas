package org.tdd;

/**
 * Created by Pascual on 24/12/2016.
 */
class Grid {
    private static final int[] NORTH = {0,1};
    private static final int[] EAST = {1,0};
    private static final int[] SOUTH = {0,-1};
    private static final int[] WEST = {-1,0};

    int size = 0;

    Grid(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    static int getRotatedHeadingAngle(int heading, int angle) {
        int squaredAngle = Math.round(angle/90)*90;
        return (squaredAngle + heading + 360)%360;
    }

    static int[] getHeadingVector(int headingAngle) {
        switch(headingAngle){
            case 0:return EAST;
            case 90:return NORTH;
            case 180:return WEST;
            case 270:return SOUTH;
        }
        return null;
    }

    public static int[] getMovingVector(int[] headingVector, int direction) {
        int[] oppositeVector = {-headingVector[0],-headingVector[1]};
        if(direction>=0) return headingVector;
        else return oppositeVector;
    }

    static int[] getMovement(int heading, int longitude) {
        int[] headingVector = NORTH;
        switch(heading){
            case 0: headingVector = EAST;break;
            case 90: headingVector = NORTH;break;
            case 180: headingVector = WEST;break;
            case 270: headingVector = SOUTH;break;
        }
        int[] movementVector = {longitude*headingVector[0],longitude*headingVector[1]};
        return movementVector;
    }

    int[] getNewPosition(int[] currentPosition, int[] movement) {
        int newX = (currentPosition[0]+movement[0])%size;
        if(newX<0) newX = newX + size;
        int newY = (currentPosition[1]+movement[1])%size;
        if(newY<0) newY = newY + size;
        int[] newPosition = {newX,newY};
        return newPosition;
    }



}
