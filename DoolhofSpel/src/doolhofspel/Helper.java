/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Menno
 */
public class Helper extends Item {

    private int index = 1;
    ArrayList<Integer> route = new ArrayList<>();
    private int Vriendxco;
    private int Vriendyco;
    
    private Richting prior1;
    private Richting prior2;
    private Richting prior3;
    private Richting prior4;

    public Helper(Veld veld, boolean pickup) {
        super(veld);
        imgIc = new ImageIcon("src/images/helper.png");
        img = imgIc.getImage();
        this.name = "helper";
        this.setPickup(pickup);
    }

    @Override
    public void uitvoeren(Speler speler) {
        checkRoute(speler.veld);
    }

    public void checkRoute(Veld current) {
        current.setBekeken(true);
        if (!(current.getObject() instanceof Muur)) {
            current.setIndex(index);
            route.add(index);
            index++;
            
            setPriority(current);
            
            if (current.getObject() instanceof Vriend) {
                backTrack(current);
            } else {
                if (current.getBuur(prior1) != null && !(current.getBuur(prior1).isBekeken())) {
                    checkRoute(current.getBuur(prior1));
                }
                if (current.getBuur(prior2) != null && !(current.getBuur(prior2).isBekeken())) {
                    checkRoute(current.getBuur(prior2));
                }
                if (current.getBuur(prior3) != null && !(current.getBuur(prior3).isBekeken())) {
                    checkRoute(current.getBuur(prior3));
                }
                if (current.getBuur(prior4) != null && !(current.getBuur(prior4).isBekeken())) {
                    checkRoute(current.getBuur(prior4));
                }
            }
        }
    }

    public void backTrack(Veld current) {
        for (int i = route.size(); i > 0; i--) {
            if (i == current.getBuur(Richting.NORTH).getIndex()) {
                ImageIcon image = new ImageIcon("src/images/route.png");
                current.setImage(image);
                current = current.getBuur(Richting.NORTH);
                route.remove(i);
            } else if (i == current.getBuur(Richting.EAST).getIndex()) {
                ImageIcon image = new ImageIcon("src/images/route.png");
                current.setImage(image);
                current = current.getBuur(Richting.EAST);
                route.remove(i);
            } else if (i == current.getBuur(Richting.SOUTH).getIndex()) {
                ImageIcon image = new ImageIcon("src/images/route.png");
                current.setImage(image);
                current = current.getBuur(Richting.SOUTH);
                route.remove(i);
            } else if (i == current.getBuur(Richting.WEST).getIndex()) {
                ImageIcon image = new ImageIcon("src/images/route.png");
                current.setImage(image);
                current = current.getBuur(Richting.WEST);
                route.remove(i);
            }
        }
    }

    public void setPriority(Veld current) {
        int currentX = current.getXCo() / 32;
        int currentY = current.getYCo() / 32;
        int verschilX;
        int verschilY;
        
        String richt = "";

        if (currentX >= Vriendxco) {
            richt = "w";
            verschilX = currentX - Vriendxco;
        } else {
            richt = "e";
            verschilX = Vriendxco - currentX;
        }
        if (currentY >= Vriendyco) {
            richt = "n";
            verschilY = currentY - Vriendyco;
        } else {
            richt = "s";
            verschilY = Vriendyco - currentY;
        }

        if (verschilY >= verschilX && "w".equals(richt)) {
            prior1 = Richting.WEST;
            prior2 = Richting.SOUTH;
            prior3 = Richting.NORTH;
            prior4 = Richting.EAST;
        }
        else if(verschilX >= verschilY && "e".equals(richt))
           {
                    prior1 = Richting.EAST;
                    prior2 = Richting.NORTH;
                    prior3 = Richting.SOUTH;
                    prior4 = Richting.WEST;
            }
        else if(verschilY <= verschilX && "n".equals(richt))
        {
            prior1 = Richting.NORTH;
            prior2 = Richting.EAST;
            prior3 = Richting.WEST;
            prior4 = Richting.SOUTH;
        }
        else
        {
            prior1 = Richting.SOUTH;
            prior2 = Richting.WEST;
            prior3 = Richting.EAST;
            prior4 = Richting.NORTH;
        }
    }
        public void setVriendXco(int xco)
        {
            this.Vriendxco = xco;
        }
        public void setVriendYco(int yco)
        {
            this.Vriendyco = yco;
        }
    }

