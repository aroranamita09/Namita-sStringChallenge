package com.stackroute;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NamitaStringChallengeTest {
    NamitaStringChallenge obj;
    @Before
    public void setUp() throws Exception {
        obj = new NamitaStringChallenge();
    }

    @After
    public void tearDown() throws Exception {
        obj = null;
    }
    @Test
    public void checkIt() {
        assertEquals(3,obj.checkIt("str",2,3,3));
    }
}