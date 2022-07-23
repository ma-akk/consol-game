package edu.school21.game;

public class Card {

    private int size;
    private Enemy[] enemies;
    private Player player;
    private Wall[] walls;
    private Position gameGoal;
    private Design empty;
    private char[][] posArray;

    public Card(int size, Enemy[] enemies, Player player, Wall[] walls, Position gameGoal, Design empty, char[][] positionsArray) {
        this.size = size;
        this.enemies = enemies;
        this.player = player;
        this.walls = walls;
        this.gameGoal = gameGoal;
        this.empty = empty;
        this.posArray = positionsArray;
    }

    public Card(Card other) {
        this.size = other.size;
        this.enemies = other.enemies;
        this.player = other.player;
        this.walls = other.walls;
        this.gameGoal = other.gameGoal;
        this.empty = other.empty;
        this.posArray = other.posArray;
    }

    public Card(DesignList designList, int size, int enemiesCount, int wallsCount) {
        if (enemiesCount + wallsCount + 2 > size * size)
            throw new IllegalParametersException("Too many enemies and walls!");
        this.size = size;
        this.enemies = new Enemy[enemiesCount];
        this.walls = new Wall[wallsCount];
        this.posArray = new char[size][size];
        this.empty = new Design(designList.empty);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Wall[] getWalls() {
        return walls;
    }

    public void setWalls(Wall[] walls) {
        this.walls = walls;
    }

    public Position getGameGoal() {
        return gameGoal;
    }

    public void setGameGoal(Position gameGoal) {
        this.gameGoal = gameGoal;
    }

    public Design getEmpty() {
        return empty;
    }

    public void setEmpty(Design empty) {
        this.empty = empty;
    }

    public char[][] getPosArray() {
        return posArray;
    }

    public void setPosArray(char[][] positionsArray) {
        this.posArray = positionsArray;
    }

}
