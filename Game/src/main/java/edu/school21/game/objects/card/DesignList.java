package edu.school21.game;

import java.awt.*;

public class DesignList {
    private Design enemy = new Design();
    private Design player = new Design();
    private Design wall = new Design();
    private Design goal = new Design();
    private Design empty = new Design();

    public DesignList() {

    }
    public DesignList(DesignList other) {
        this.enemy = other.enemy;
        this.player = other.player;
        this.wall = other.wall;
        this.goal = other.goal;
        this.empty = other.empty;

    }

    public DesignList(Design enemy, Design player, Design wall, Design goal, Design empty) {
        this.enemy = enemy;
        this.player = player;
        this.wall = wall;
        this.goal = goal;
        this.empty = empty;
    }

    public void setParams(Design enemy, Design player, Design wall, Design goal, Design empty){
        this.enemy = enemy;
        this.player = player;
        this.wall = wall;
        this.goal = goal;
        this.empty = empty;
    }

    @Override
    public String toString() {
        return "DesignList{" +
                "\nenemy=" + enemy +
                ", \nplayer=" + player +
                ", \nwall=" + wall +
                ", \ngoal=" + goal +
                ", \nempty=" + empty +
                '}';
    }

    public Design getEnemy() {
        return enemy;
    }

    public void setEnemy(Design enemy) {
        this.enemy = enemy;
    }

    public Design getPlayer() {
        return player;
    }

    public void setPlayer(Design player) {
        this.player = player;
    }

    public Design getWall() {
        return wall;
    }

    public void setWall(Design wall) {
        this.wall = wall;
    }

    public Design getGoal() {
        return goal;
    }

    public void setGoal(Design goal) {
        this.goal = goal;
    }

    public Design getEmpty() {
        return empty;
    }

    public void setEmpty(Design empty) {
        this.empty = empty;
    }

    public Color getEnemyColor() {
        return enemy.getColor();
    }

    public void setEnemy(Color color, char c) {
        this.enemy.setColor(color);
        this.enemy.setSymbol(c);
    }

    public Color getPlayerColor() {
        return player.getColor();
    }

    public void setPlayer(Color color, char c) {
        this.player.setColor(color);
        this.player.setSymbol(c);
    }

    public Color getWallColor() {
        return wall.getColor();
    }

    public void setWall(Color color, char c) {
        this.wall.setColor(color);
        this.wall.setSymbol(c);
    }

    public Color getGoalColor() {
        return goal.getColor();
    }

    public void setGoal(Color color, char c) {
        this.goal.setColor(color);
        this.goal.setSymbol(c);
    }

    public Color getEmptyColor() {
        return empty.getColor();
    }

    public void setEmpty(Color color, char c) {
        this.empty.setColor(color);
        this.empty.setSymbol(c);
    }
}
