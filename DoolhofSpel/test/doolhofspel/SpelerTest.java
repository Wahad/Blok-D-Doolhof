/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Menno
 */
public class SpelerTest {
    
    public SpelerTest() {
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
     * Test of bewegen method, of class Speler.
     */
    @Test
    public void testBewegen() {
        System.out.println("bewegen");
        Richting r = null;
        Speler instance = null;
        instance.bewegen(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
