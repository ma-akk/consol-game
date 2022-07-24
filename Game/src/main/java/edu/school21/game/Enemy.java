package edu.school21.game;

public class Enemy extends Character {
    public Enemy(Position position) {
        this.characterPos = new Position(position);
    }

    public Enemy(int x, int y, Design design, Type type) {
        this.characterPos = new Position(x, y, design, type);
    }

    public Enemy() {
    }

//    getter for char[][]
//    getStepDirection(int x, int y, char[][] card, char enemy, char player, char empty)
//        StepDirection.getX and getY
//            changePosition();
//    positionCardBySymbolArray()


}
