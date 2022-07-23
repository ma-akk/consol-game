package edu.school21.game;

import java.util.Random;

public class Card {
    private static final double EMPTY_VS_ENEMIES = 0.8;

    private int size;
    private int enemiesCount;
    private int wallsCount;
    private DesignList designList;
    private Enemy[] enemies;
    private Player player;
    private Wall[] walls;
    private Position gameGoal;
    private Design empty;
    private char[][] symbolArray;
    private Position[][] positionArray;

    public Card(Card other) {
        this.size = other.size;
        this.enemiesCount = other.enemiesCount;
        this.wallsCount = other.wallsCount;
        this.designList = other.designList;
        this.enemies = other.enemies;
        this.player = other.player;
        this.walls = other.walls;
        this.gameGoal = other.gameGoal;
        this.empty = other.empty;
        this.symbolArray = other.symbolArray;
        this.positionArray = other.positionArray;
    }

    public Card(int size, int enemiesCount, int wallsCount, DesignList designList, Player player) {
        this.size = size;
        this.enemiesCount = enemiesCount;
        this.wallsCount = wallsCount;
        this.designList = designList;
        this.player = player;
    }

    public Card(DesignList designList, int size, int enemiesCount, int wallsCount) {
        if (enemiesCount + wallsCount > EMPTY_VS_ENEMIES * size * size)
            throw new IllegalParametersException("Too many enemies and walls!");
        this.size = size;
        this.enemiesCount = enemiesCount;
        this.wallsCount = wallsCount;
        this.designList = designList;
        this.empty = new Design(designList.empty);
        this.enemies = new Enemy[enemiesCount];
        this.walls = new Wall[wallsCount];
        this.symbolArray = new char[size + 2][size + 2];
        this.positionArray = new Position[size + 2][size + 2];
        generateCard();
    }

    public void generateEmptyCard(){
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++){
                if (i == 0 || j == 0 || i == size + 1 || j == size + 1){
                    positionArray[i][j].setParams(i, j, designList.wall, Type.WALL);
                } else {
                    positionArray[i][j].setParams(i, j, designList.empty, Type.EMPTY);
                }
            }
        }
    }

    public void generateCard(){
        generateEmptyCard();

        Random rand = new Random(System.currentTimeMillis());
        // Walls

    }

    public DesignList getDesignList() {
        return designList;
    }

    public void setDesignList(DesignList designList) {
        this.designList = designList;
    }

    public int getEnemiesCount() {
        return enemiesCount;
    }

    public void setEnemiesCount(int enemiesCount) {
        this.enemiesCount = enemiesCount;
    }

    public int getWallsCount() {
        return wallsCount;
    }

    public void setWallsCount(int wallsCount) {
        this.wallsCount = wallsCount;
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

    public char[][] getSymbolArray() {
        return symbolArray;
    }

    public void setSymbolArray(char[][] positionsArray) {
        this.symbolArray = positionsArray;
    }

}
