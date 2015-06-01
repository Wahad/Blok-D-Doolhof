/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Menno
 */
public class LevelTest {
    
    public LevelTest() {
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
     * Test of paintComponent method, of class Level.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Level instance = new Level();
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restart method, of class Level.
     */
    @Test
    public void testRestart() {
        System.out.println("restart");
        Level instance = new Level();
        instance.restart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
