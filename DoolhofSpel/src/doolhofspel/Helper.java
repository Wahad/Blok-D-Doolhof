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

    public Helper(Veld veld, boolean pickup) {
        super(veld);
        imgIc = new ImageIcon("src/images/helper.png");
        img = imgIc.getImage();
        this.name = "helper";
        this.pickup = false;
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
            
            if (current.getObject() instanceof Vriend) {
                backTrack(current);
            } else {
                if (current.getBuur(Richting.NORTH) != null && !(current.getBuur(Richting.NORTH).isBekeken())) {
                    checkRoute(current.getBuur(Richting.NORTH));
                }
                if (current.getBuur(Richting.EAST) != null && !(current.getBuur(Richting.SOUTH).isBekeken())) {
                    checkRoute(current.getBuur(Richting.SOUTH));
                }
                if (current.getBuur(Richting.WEST) != null && !(current.getBuur(Richting.WEST).isBekeken())) {
                    checkRoute(current.getBuur(Richting.WEST));
                }
                if (current.getBuur(Richting.SOUTH) != null && !(current.getBuur(Richting.SOUTH).isBekeken())) {
                    checkRoute(current.getBuur(Richting.SOUTH));
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

        
    }

