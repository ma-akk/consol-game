package edu.school21.game;

import java.awt.*;

public class Design {
    private Color color;
    private char symbol;

    public Design() {
    }

    @Override
    public String toString() {
        return "Design{" +
                "color=" + color +
                ", symbol=" + symbol +
                '}';
    }

    public Design(Color color, char symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public Design(Design other) {
        this.color = other.color;
        this.symbol = other.symbol;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
