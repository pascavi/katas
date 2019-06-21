package org.tdd;

class RotateCommand implements Command{
    private int angle;

     RotateCommand(int angle) {
        this.angle = angle;
    }

    public CommandType getType(){
         return CommandType.ROTATE;
    }

    public int getAngle(){
        return angle;
    }


}
