package edu.school21.game;

import java.awt.*;

public class Position {

    private int x;
    private int y;
    private Color color;
    private char design;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public char getDesign() {
        return design;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDesign(char design) {
        this.design = design;
    }

    public int[] getCoordinates() {
        return new int[]{x, y};
    }
}
