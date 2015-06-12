/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Menno
 */
public class Helper extends Item {

    private final int MAX_WAARDE = 1000;
    private int kortsteRoute;
    private int aantalKolRij;
    private Veld[][] veldLijst;
    public String[][] oplossing;
    public String[][] doolhof;
    private boolean gevonden = false;


    public Helper(Veld veld, boolean pickup) {
        super(veld);
        imgIc = new ImageIcon("src/images/helper.png");
        img = imgIc.getImage();
        this.name = "helper";
        this.setPickup(pickup);
        oplossing = null;
        doolhof = new String[20][20]; // aantal kolommen en rijen van het level: 20 bij 20
    }

    @Override
    public void uitvoeren(Speler speler) {
        losOp(veld.getXCo()/32, veld.getYCo()/32);
        setGevonden(true);
    }

    public void arrayOmzetten() {
        for (int y = 0; y < aantalKolRij; y++) 
        {
            for (int x = 0; x < aantalKolRij; x++) 
            {

                Veld huidig = veldLijst[y][x];
                if (huidig.getObject() != null && huidig.getObject() instanceof Muur) {
                    doolhof[y][x] = "M";
                }
                if (huidig.getObject() != null && huidig.getObject() instanceof Schep) {
                    doolhof[y][x] = "P";
                }
                if (huidig.getObject() != null && huidig.getObject() instanceof ValsSpeler) {
                    doolhof[y][x] = "P";
                }
                if (huidig.getObject() != null && huidig.getObject() instanceof Vriend) {
                    doolhof[y][x] = "V";
                }
                if (huidig.getObject() == null) {
                    doolhof[y][x] = "P";
                }
            }
        }
    }
    // Maakt een copy van de Stringlijst zodat deze kan dienen als oploslijst
    
    public void copyDoolhof()
    {
        oplossing = new String[aantalKolRij][aantalKolRij];
        for (int x = 0; x < aantalKolRij; x++)
        {
            System.arraycopy(doolhof[x], 0, oplossing[x], 0, aantalKolRij);
        }
    }
    
    public void losOp(int x, int y)
    {
        kortsteRoute = MAX_WAARDE;
        aantalKolRij = veldLijst.length;
        // deze nested for loop is de eind locatie, vriend
        for (int q = 0; q < aantalKolRij; q++)
        {
            for (int r = 0; r < aantalKolRij; r++)
            {
                if (veldLijst[q][r].getObject() != null && veldLijst[q][r].getObject() instanceof Vriend)
                {
                    doolhof[q][r] = "V";
                }
            }
        }
        arrayOmzetten();
        kortsteRoute = MAX_WAARDE;

        if (stap(x, y, 0) != MAX_WAARDE)
        {
            oplossing[x][y] = "S";
        }
    }
    public int stap(int x, int y, int aantalStappen)
    {
        int i = 0;
        // Zoek vriend
        if ("V".equals(doolhof[x][y]))
        {
            kortsteRoute = aantalStappen;
            copyDoolhof();
            return aantalStappen;
        }

        // Deze stap gaat niet omdat de stap naar een Muur is of omdat het pad al is gemarkeerd
        if ("M".equals(doolhof[x][y]) || "*".equals(doolhof[x][y]))
        {
            return MAX_WAARDE;
        }
        // dit pad (van vriend naar begin) is langer dan het al eerder gevonden pad (van begin naar vriend)
        if (aantalStappen == kortsteRoute)
        {
            return MAX_WAARDE;
        }

        //markeer deze stap (van het pad) als oplossing
        doolhof[x][y] = "*";
        int uitkomst = MAX_WAARDE;

        int nieuweUitkomst = MAX_WAARDE;

        // omhoog
        nieuweUitkomst = stap(x, y - 1, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst)
        {
            uitkomst = nieuweUitkomst;
        }

        // omlaag
        nieuweUitkomst = stap(x, y + 1, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst)
        {
            uitkomst = nieuweUitkomst;
        }

        // links
        nieuweUitkomst = stap(x - 1, y, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst)
        {
            uitkomst = nieuweUitkomst;
        }

        // rechts
        nieuweUitkomst = stap(x + 1, y, aantalStappen + 1);
        if (nieuweUitkomst < uitkomst)
        {
            uitkomst = nieuweUitkomst;
        }

        // maak de markering ongedaan
        doolhof[x][y] = "P";

        if (uitkomst < MAX_WAARDE)
        {
            return uitkomst;
        }

        return MAX_WAARDE;
    }
    public void setVeldLijst(Veld[][] doolhof)
    {
        this.veldLijst = doolhof;
    }
    
    public boolean isGevonden() {
        return gevonden;
    }

    public void setGevonden(boolean gevonden) {
        this.gevonden = gevonden;
    }
    public void paintRoute(Graphics g)
    {

        ImageIcon imgIc = new ImageIcon("src/images/route.png");
        img = imgIc.getImage();

        for (int x = 0; x < aantalKolRij; x++)
        {
            for (int y = 0; y < aantalKolRij; y++)
            {
                if ("*".equals(oplossing[y][x]))
                {

                    g.drawImage(img, y * 32, x * 32, null);
                }
            }
        }
    }
}
