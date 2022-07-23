package edu.school21.game;

import java.awt.*;

public class Position {

    private int x;
    private int y;
    private Color color;
    private char design;

    public Position(int x, int y, Color color, char design) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.design = design;
    }

    public Position(Position other) {
        this.x = other.x;
        this.y = other.y;
        this.color = new Color(other.color.getRGB());
        this.design = other.design;
    }

    public Position() {
    }

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

    public void incX() {
        this.x++;
    }

    public void decX() {
        this.x--;
    }

    public void incY() {
        this.y++;
    }

    public void decY() {
        this.y--;
    }
}
