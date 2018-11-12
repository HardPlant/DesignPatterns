package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BuildersTest extends TestCase{

    public void testHelloWorld(){
        assertEquals("hello world", MessageBuilder.getHelloWorld());
    }

    public void testNumber10(){
        assertEquals(10, MessageBuilder.getNumber10());
    }
}