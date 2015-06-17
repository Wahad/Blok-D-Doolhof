/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.util.Random;
import javax.swing.ImageIcon;

public class Teleporter extends Item {
    Veld[][] veldenLijst;
    Veld randomVeld;
    
    public Teleporter(Veld veld, boolean pickup) {
        super(veld);
        imgIc = new ImageIcon("src/images/teleporter.png");
        img = imgIc.getImage();
        this.name = "teleporter";
        this.setPickup(pickup);
    }

    @Override
    public void uitvoeren(Speler speler) {
       Veld spelerVeld = speler.getVeld();
       spelerVeld.setObject(null);
       Veld randomveld = getRandomVeld();
       speler.setVeld(randomVeld);
       randomveld.setObject(speler);
    }

    private Veld getRandomVeld() {
        veldenLijst = level.getVeldenLijst();
        Random rand = new Random();
        int waardeX = rand.nextInt(veldenLijst.length) + 1;
        int waardeY = rand.nextInt(veldenLijst.length) + 1;
                 
        for (Veld[] veldenLijst1 : veldenLijst) {
            for (Veld v : veldenLijst1) {
                if(waardeX == v.getXCo()/32 && waardeY == v.getYCo()/32)
                {
                    if (v.getObject() != null) {
                        getRandomVeld();
                    }
                    else
                    {
                        randomVeld = v;
                    }
                }
            }
        }
        
        return randomVeld;
    }
  
}

