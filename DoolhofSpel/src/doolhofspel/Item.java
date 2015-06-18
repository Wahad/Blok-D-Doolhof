/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;


/**
 *
 * @author Menno
 */

public class Item extends SpelObject{
    
    protected String name;
    protected boolean pickup;
    
    public Item(Veld veld) {
        super(veld);
    }
     public void uitvoeren(Speler speler)
    {
        
    }

    public boolean isPickup() {
        return pickup;
    }

    public void setPickup(boolean pickup) {
        this.pickup = pickup;
    }
    
}
