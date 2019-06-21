package org.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandReaderTest {
    CommandReader commandReader = new CommandReader();
    @Before
    public void setUp(){

    }

    @Test
    public void command_string_breaks_into_list() {
        char[] actual = commandReader.splitString("LFFRBL");
        char[] expected = {'L' ,'F','F','R','B','L'};
        Assert.assertArrayEquals(expected,actual);
    }

    @Test(expected = Exception.class)
    public void wrong_character_launches_exception() throws Exception{
        commandReader.readCommand('X');
    }

    @Test
    public void command_characters_are_correctly_classified() throws Exception{
        Command command;
        command = commandReader.readCommand('L');
        Assert.assertEquals(CommandType.ROTATE,command.getType());
        command = commandReader.readCommand('R');
        Assert.assertEquals(CommandType.ROTATE,command.getType());
        command = commandReader.readCommand('F');
        Assert.assertEquals(CommandType.MOVE,command.getType());
        command = commandReader.readCommand('B');
        Assert.assertEquals(CommandType.MOVE,command.getType());
    }

    @Test
    public void rotate_command_gets_correct_angle() throws Exception{
        Assert.assertEquals(90, CommandReader.getRotationAngle('L'));
        Assert.assertEquals(-90, CommandReader.getRotationAngle('R'));
    }

    @Test
    public void move_command_gets_correct_direction() throws Exception{
        Assert.assertEquals(1, CommandReader.getMoveDirection('F'));
        Assert.assertEquals(-1, CommandReader.getMoveDirection('B'));
    }




}
