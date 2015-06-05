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
        
        Veld veld = new Veld(10, 10);
        Veld buurveld = new Veld(10, 11);
        veld.setBuur(Richting.SOUTH, buurveld);
        Speler instance = new Speler(veld);
        SpelObject schep = new Schep(buurveld, true);
        veld.setObject(instance);
        buurveld.setObject(schep);
        instance.bewegen(Richting.SOUTH);
        Item verwacht = (Item) schep;
        Item echt = instance.heeft;
        
        //int verwachtY = 11;
        //int echteY = instance.veld.getYCo();
        //assertEquals(verwachtY, echteY);
        assertEquals(verwacht, echt);
       
    }

    /**
     * Test of getaantalStappen method, of class Speler.
     */
    @Test
    public void testGetaantalStappen() {
        System.out.println("getaantalStappen");
        Speler instance = new Speler(new Veld(1, 1));
        int expResult = 0;
        int result = instance.getaantalStappen();
        assertEquals(expResult, result);
    }

    /**
     * Test of setaantalStappen method, of class Speler.
     */
    @Test
    public void testSetaantalStappen() {
        System.out.println("setaantalStappen");
        int aantalStappen = 5;
        Speler instance = new Speler(new Veld(1, 1));
        instance.setaantalStappen(aantalStappen);
        int resultaat = 5;
        assertEquals(instance.getaantalStappen(), resultaat);
        
    }
}
