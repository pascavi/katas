package org.tdd;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrintDateTest {
    PrintDate printDate;
    @Before
    public void setUp() {
        //  create mock
        printDate = Mockito.mock(PrintDate.class);
    }


    @Test
    public void firstTest() throws Exception {
        assertThat(false, is(true));
    }


}
