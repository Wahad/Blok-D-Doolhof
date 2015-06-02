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
        speler.aantalStappen = 40;
        int verwachtaantal = 20;
        ValsSpeler instance = new ValsSpeler(new Veld(1, 1));
        
        instance.uitvoeren(speler);
        
        assertEquals(speler.aantalStappen, verwachtaantal);
        //fail("Het aantalstappen is niet verminderd.");
    }
}
