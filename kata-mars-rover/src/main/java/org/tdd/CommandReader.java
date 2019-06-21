package org.tdd;

class CommandReader {

    char[] splitString(final String commandsString) {
        char[] charArray = new char[commandsString.length()];
        for(int i=0;i<commandsString.length();i++){
            charArray[i] = commandsString.charAt(i);
        }
        return charArray;
    }

    Command readCommand(final Character character) throws Exception{
        switch(character){
            case 'L': return new RotateCommand(getRotationAngle(character));
            case 'R': return new RotateCommand(getRotationAngle(character));
            case 'F': return new MoveCommand(character);
            case 'B': return new MoveCommand(character);
        }
        throw new Exception();
    }

    static int getRotationAngle(final Character character){
        return character.equals('L')? 90:-90;
    }

    static int getMoveDirection(final Character character){
        return character.equals('F')? 1:-1;
    }
}
