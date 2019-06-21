package org.tdd;

class MoveCommand implements Command{
    int factor;

    MoveCommand(int factor) {
        this.factor = factor;
    }

    int getFactor() {
        return factor;
    }

    public CommandType getType(){
        return CommandType.MOVE;
    }

}
