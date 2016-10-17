package org.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class StringCalculatorTest {
    StringCalculator stringCalculator;


    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }


    @Test
    public void EmptyStringReturnsZero() throws Exception {
        int result = stringCalculator.add("");
        assertThat(result, is(0));
    }


    @Test
    public void OneReturnsOne() throws Exception{
        int result = stringCalculator.add("1");
        assertThat(result,is(1));
    }

    @Test
    public void TwoReturnsTwo() throws Exception {
        int result = stringCalculator.add("2");
        assertThat(result,is(2));
    }

    @Test
    public void OneTwoReturnsThree() throws Exception {
        int result = stringCalculator.add("1,2");
        assertThat(result,is(3));
    }

    @Test
    public void OneTwoThreeReturnsSix() throws Exception {
        int result = stringCalculator.add("1,2,3");
        assertThat(result,is(6));
    }

    @Test
    public void OneBreakTwoThreeReturnsSix() throws Exception {
        int result = stringCalculator.add("1\n2,3");
        assertThat(result,is(6));
    }

    @Test
    public void ColonDelimiterOneTwoReturnsThree() throws Exception {
        int result = stringCalculator.add("//;\n1;2");
        assertThat(result,is(3));
    }

    @Test
    public void NegativeNumberThrowsException() {
        try {
            stringCalculator.add("1,-1");
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("negatives not allowed: -1"));
            //assert others
        }
    }

    @Test
    public void Over1000NumbersAreIgnored() throws Exception {
        int result = stringCalculator.add("2,2002");
        assertThat(result,is(2));
    }

    @Test
    public void MulticharacterDelimiterAreAccepted() throws Exception {
        int result = stringCalculator.add("//[***]\n1***2***3");
        assertThat(result,is(6));
    }

    @Test
    public void MultiDelimitersAreAccepted() throws Exception {
        int result = stringCalculator.add("//[*][%]\n1*2%3");
        assertThat(result,is(6));
    }

    @Test
    public void MultiDelimitersWithMultiCharactersAreAccepted() throws Exception {
        int result = stringCalculator.add("//[***][%%%]\n1***2%%%3");
        assertThat(result,is(6));
    }


}
