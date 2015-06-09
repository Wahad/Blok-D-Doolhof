/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Gebruiker
 */
public class SchepTest {
    
    public SchepTest() {
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
     * Test of uitvoeren method, of class Schep.
     */
    @Test
    public void testUitvoerenBinnenMuur() {
        System.out.println("uitvoeren");
        Veld startveld = new Veld(10, 10);
        Speler speler = new Speler(startveld);
        startveld.setObject(speler);
        Schep instance = new Schep(new Veld(9, 10), true);
        
        speler.heeft = instance;
        Veld veld = new Veld(10, 11);
        Muur binnenmuur = new Muur(veld, false);
        veld.setObject(binnenmuur);
        startveld.setBuur(Richting.SOUTH, veld);
        veld.setBuur(Richting.NORTH, startveld);
        speler.richt = Richting.SOUTH;
        instance.uitvoeren(speler);
        SpelObject expected = null;
        SpelObject actual = veld.getObject();
        
        assertEquals(expected, actual);
        //fail("The test case is a prototype.");
    }
    @Test
    public void testUitvoerenBuitenMuur() {
        System.out.println("uitvoeren");
        Veld startveld = new Veld(10, 10);
        Speler speler = new Speler(startveld);
        startveld.setObject(speler);
        Schep instance = new Schep(new Veld(9, 10), true);
        speler.heeft = instance;
        Veld veld = new Veld(10, 11);
        Muur buitenmuur = new Muur(veld, true);
        veld.setObject(buitenmuur);
        startveld.setBuur(Richting.SOUTH, veld);
        veld.setBuur(Richting.NORTH, startveld);
        
        speler.richt = Richting.SOUTH;
        instance.uitvoeren(speler);
        SpelObject expected = buitenmuur;
        SpelObject actual = veld.getObject();
        
        assertEquals(expected, actual);
        //fail("The test case is a prototype.");
    }
}
