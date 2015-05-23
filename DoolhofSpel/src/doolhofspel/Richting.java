/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofspel;

/**
 *
 * @author Gebruiker
 */
public enum Richting {

    NORTH("north"), EAST("east"), SOUTH("south"), WEST("west");
    private final String richting;

    public String getRichting() {
        return richting;
    }

    Richting(String r) {
        richting = r;
    }
}
