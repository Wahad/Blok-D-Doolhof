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
    public void testBewegenZuid() {
        Veld veld = new Veld(10, 10);
        Speler instance = new Speler(veld);
        Veld buurveldzuid = new Veld(10, 11);
        veld.setBuur(Richting.SOUTH, buurveldzuid);
        
        veld.setObject(instance);
        instance.bewegen(Richting.SOUTH);
        
        int verwachtYZuid = 11;
        int echteYZuid = instance.veld.getYCo();
        assertEquals(verwachtYZuid, echteYZuid);
    }
    
    @Test
    public void testBewegenNoord() {  
        Veld veld = new Veld(10, 10);
        Speler instance = new Speler(veld);
        Veld buurveldnoord = new Veld(10, 9);
        veld.setBuur(Richting.NORTH, buurveldnoord);
        
        veld.setObject(instance);
        instance.bewegen(Richting.NORTH);
        
        int verwachtyNoord = 9;
        int echteyNoord = instance.veld.getYCo();
        assertEquals(verwachtyNoord, echteyNoord);
        }
    @Test
    public void testBewegenOost() {   
        Veld veld = new Veld(10, 10);
        Speler instance = new Speler(veld);
        Veld buurveldoost = new Veld(11, 10);
        veld.setBuur(Richting.EAST, buurveldoost);
        
        veld.setObject(instance);
        instance.bewegen(Richting.EAST);
        
        int verwachtxOost = 11;
        int echtexOost = instance.veld.getXCo();
        assertEquals(verwachtxOost, echtexOost);
        }
    @Test
    public void testBewegenWest() {   
        Veld veld = new Veld(10, 10);
        Speler instance = new Speler(veld);
        Veld buurveldwest = new Veld(9, 10);
        veld.setBuur(Richting.WEST, buurveldwest);
        
        veld.setObject(instance);
        instance.bewegen(Richting.WEST);
        
        int verwachtXWest = 9;
        int echteXWest = instance.veld.getXCo();
        assertEquals(verwachtXWest, echteXWest);
        
    }   
    @Test
    public void testBewegenMuur() {
        Veld veld = new Veld(10, 10);
        Veld buurveldmuur = new Veld(9, 10);
        veld.setBuur(Richting.WEST, buurveldmuur);
        Speler instance5 = new Speler(veld);
        
        veld.setObject(instance5);
        buurveldmuur.setObject(new Muur(buurveldmuur, false));
        instance5.bewegen(Richting.WEST);
        
        int verwachtmuurX = 10;
        int echtemuurX = instance5.veld.getXCo();
        assertEquals(verwachtmuurX, echtemuurX);
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
