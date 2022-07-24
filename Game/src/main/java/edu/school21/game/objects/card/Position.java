package edu.school21.game;

import java.awt.*;

public class Position {

    private int x;
    private int y;
    private Design design;
    private Type type;

    public Position(int x, int y, Design design, Type type) {
        this.x = x;
        this.y = y;
        this.design = design;
        this.type = type;
    }

    public Position(int x, int y, Color color, char c, Type type) {
        this.x = x;
        this.y = y;
        this.design = new Design(color, c);
        this.type = type;
    }

    public Position(Position other) {
        this.x = other.x;
        this.y = other.y;
        this.design = other.design;
        this.type = other.type;
    }

    public Position() {
    }

    public Type getType() {
        return type;
    }

    public void setParams(int x, int y, Design design, Type type){
        this.x = x;
        this.y = y;
        this.design = design;
        this.type = type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return design.getColor();
    }

    public char getSymbol() {
        return design.getSymbol();
    }

    public void setSymbol(char c){
        this.design.setSymbol(c);
    }

    public Design getDesign() {
        return design;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.design.setColor(color);
    }

    public void setDesign(Design design) {
        this.design = design;
    }

    public int[] getCoordinates() {
        return new int[]{y, x};
    }

    public void incX() {
        this.y--;
    }

    public void decX() {
        this.y++;
    }

    public void incY() {
        this.x++;
    }

    public void decY() {
        this.x--;
    }

    @Override
    public boolean equals(Object obj) {

        Position other = (Position) obj;

        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {

        final int prime = 31;

        int result = 1;

        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
}
