/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Gebruiker
 */
public class ValsSpelerTest {
    
    public ValsSpelerTest() {
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
     * Test of uitvoeren method, of class ValsSpeler.
     */
    @Test
    public void testUitvoeren() {
        System.out.println("uitvoeren");
        Speler speler = new Speler(new Veld(1, 1));
        speler.setaantalStappen(40);
        Random rand = new Random();
        int waarde = rand.nextInt(20) + 1;
        int verwachtaantal = 40-waarde;
        ValsSpeler instance = new ValsSpeler(new Veld(1, 1), waarde);
        
        instance.uitvoeren(speler);
        
        assertEquals(speler.getaantalStappen(), verwachtaantal);
        //fail("Het aantalstappen is niet verminderd.");
    }
}
