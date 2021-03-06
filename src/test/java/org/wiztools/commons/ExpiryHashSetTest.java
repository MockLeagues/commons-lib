/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author subwiz
 */
public class ExpiryHashSetTest {

    public ExpiryHashSetTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class AbstractExpiryCollection.
     */
    @Test
    public void testTiming() {
        ExpiryCollection<String> s = new ExpiryHashSet<String>(50);

        final String data = "Aarthi";
        s.acquire();
        s.add(data, System.currentTimeMillis() + 30);
        assertEquals(s.contains(data), true);
        s.release();

        try{
            Thread.sleep(60);
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }

        s.acquire();
        assertEquals(s.contains(data), false);
        s.release();
    }

}