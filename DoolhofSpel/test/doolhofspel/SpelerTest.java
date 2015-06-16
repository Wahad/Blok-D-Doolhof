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
    public void testBewegenMuurWest() {
        Veld veld = new Veld(10, 10);
        Veld buurveldmuur = new Veld(9, 10);
        veld.setBuur(Richting.WEST, buurveldmuur);
        Speler instance = new Speler(veld);
        
        veld.setObject(instance);
        buurveldmuur.setObject(new Muur(buurveldmuur, false));
        instance.bewegen(Richting.WEST);
        
        int verwachtmuurX = 10;
        int echtemuurX = instance.veld.getXCo();
        assertEquals(verwachtmuurX, echtemuurX);
    }
    @Test
    public void testBewegenMuurNoord() {
        Veld veld = new Veld(10, 10);
        Veld buurveldmuur = new Veld(9, 10);
        veld.setBuur(Richting.NORTH, buurveldmuur);
        Speler instance = new Speler(veld);
        
        veld.setObject(instance);
        buurveldmuur.setObject(new Muur(buurveldmuur, false));
        instance.bewegen(Richting.NORTH);
        
        int verwachtmuurY = 10;
        int echtemuurY = instance.veld.getYCo();
        assertEquals(verwachtmuurY, echtemuurY);
    }
    @Test
    public void testBewegenMuurZuid() {
        Veld veld = new Veld(10, 10);
        Veld buurveldmuur = new Veld(10, 11);
        veld.setBuur(Richting.SOUTH, buurveldmuur);
        Speler instance = new Speler(veld);
        
        veld.setObject(instance);
        buurveldmuur.setObject(new Muur(buurveldmuur, false));
        instance.bewegen(Richting.SOUTH);
        
        int verwachtmuurY = 10;
        int echtemuurY = instance.veld.getYCo();
        assertEquals(verwachtmuurY, echtemuurY);
    }
    @Test
    public void testBewegenMuurOost() {
        Veld veld = new Veld(10, 10);
        Veld buurveldmuur = new Veld(11, 10);
        veld.setBuur(Richting.EAST, buurveldmuur);
        Speler instance = new Speler(veld);
        
        veld.setObject(instance);
        buurveldmuur.setObject(new Muur(buurveldmuur, false));
        instance.bewegen(Richting.EAST);
        
        int verwachtmuurX = 10;
        int echtemuurX = instance.veld.getXCo();
        assertEquals(verwachtmuurX, echtemuurX);
    }
    @Test
    public void algoritmeTestBewegen1(){
        Veld veld = new Veld(10, 10);
        Veld buurveld = new Veld(10, 9);
        veld.setBuur(Richting.NORTH, buurveld);
        Speler instance = new Speler(veld);
        
        veld.setObject(instance);
        buurveld.setObject(new Muur(buurveld, true));
        
        instance.bewegen(Richting.NORTH);
        int expectedY = 10;
        int newY = instance.veld.getYCo();
        assertEquals(expectedY, newY);
    }
    @Test
    public void algoritmeTestBewegen2(){
        Veld veld = new Veld(10, 10);
        Veld buurveld = new Veld(10, 9);
        veld.setBuur(Richting.NORTH, buurveld);
        Speler instance = new Speler(veld);
        
        veld.setObject(instance);
       
        instance.bewegen(Richting.NORTH);
        
        int expectedY = 9;
        int newY = instance.veld.getYCo();
        assertEquals(expectedY, newY);
    }
    @Test
    public void algoritmeTestBewegen3(){
        Veld veld = new Veld(10, 10);
        Veld buurveld = new Veld(10, 9);
        veld.setBuur(Richting.NORTH, buurveld);
        Speler instance = new Speler(veld);
        ValsSpeler v = new ValsSpeler(buurveld, 20, false);
        
        instance.setaantalStappen(70);
       
        veld.setObject(instance);
        buurveld.setObject(v);
        
        instance.bewegen(Richting.NORTH);
        
        int expectedY = 9;
        int newY = instance.veld.getYCo();
        assertEquals(expectedY, newY);
        int verwachtaantal = 51;
        assertEquals(verwachtaantal, instance.getaantalStappen());
    }
    @Test
    public void algoritmeTestBewegen4(){
        Veld veld = new Veld(10, 10);
        Veld buurveld = new Veld(10, 9);
        veld.setBuur(Richting.NORTH, buurveld);
        Speler instance = new Speler(veld);
        Schep s = new Schep(buurveld, true);
        
        veld.setObject(instance);
        buurveld.setObject(s);
        
        instance.bewegen(Richting.NORTH);
        
        int expectedY = 9;
        int newY = instance.veld.getYCo();
        assertEquals(expectedY, newY);
        assertEquals(instance.getInHand(), s);
    }
    @Test
    public void algoritmeTestBewegen5(){
        Veld veld = new Veld(10, 10);
        Veld buurveld = new Veld(10, 9);
        veld.setBuur(Richting.NORTH, buurveld);
        Speler instance = new Speler(veld);
        Schep s = new Schep(buurveld, true);
        ValsSpeler v = new ValsSpeler(buurveld, 40, true);
        veld.setObject(instance);
        buurveld.setObject(s);
        instance.getRugzak().add(v);
        instance.bewegen(Richting.NORTH);
        
        int expectedY = 9;
        int newY = instance.veld.getYCo();
        assertEquals(expectedY, newY);
        assertEquals(instance.getRugzak().get(0), v);
        assertEquals(instance.getRugzak().get(1), s);
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
