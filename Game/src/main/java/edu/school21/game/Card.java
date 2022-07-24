package edu.school21.game;

import java.awt.*;
import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BACK_COLOR;
import static com.diogonunes.jcolor.Attribute.WHITE_BACK;

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
        this.empty = new Design(designList.getEmpty());
        this.enemies = new Enemy[enemiesCount];
        this.walls = new Wall[wallsCount];
        this.symbolArray = new char[size + 2][size + 2];
        this.positionArray = new Position[size + 2][size + 2];
        generateCard();
    }

    public void generateEmptyCard(){
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++) {
                if (i == 0 || j == 0 || i == size + 1 || j == size + 1) {
                    positionArray[i][j] = new Position(i, j, designList.getWall(), Type.WALL);
                } else {
                    positionArray[i][j] = new Position(i, j, designList.getEmpty(), Type.EMPTY);
                }
            }
        }
    }

    public void clearCard(){
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                positionArray[i][j].setParams(i, j, designList.getEmpty(), Type.EMPTY);
            }
        }
    }

    public void generateWallsAndEnemies(){
        Random rand = new Random(System.currentTimeMillis());
        int x;
        int y;
        int exitLoop = size * size * size;
        int checkWalls = wallsCount;
        int checkEnemies = enemiesCount;
        while (checkWalls + checkEnemies > 0 && exitLoop-- > 0){
            x = rand.nextInt(size) + 1;
            y = rand.nextInt(size) + 1;
            if (positionArray[x][y].getType() == Type.EMPTY) {
                if (exitLoop % 2 == 0 && checkWalls > 0) {
                    checkWalls--;
                    positionArray[x][y].setParams(x, y, designList.getWall(), Type.WALL);
                } else if (checkEnemies > 0){
                    positionArray[x][y].setParams(x, y, designList.getEnemy(), Type.ENEMY);
                    enemies[enemiesCount - checkEnemies--] = new Enemy(x, y, designList.getEnemy(), Type.ENEMY);
                }
            }
        }
        if (checkWalls > 0 || checkEnemies > 0)
            throw new IllegalParametersException("Too many walls and enemies!");
    }

    public int generateGoalAndPlayer(int exitRecurse){
        Random rand = new Random(System.currentTimeMillis());
        int x;
        int y;
        int exitLoop = size * size * size;
        boolean goalFlag = false;
        boolean playerFlag = false;
        while ((!goalFlag || !playerFlag) && exitLoop-- > 0){
            x = rand.nextInt(size) + 1;
            y = rand.nextInt(size) + 1;
            if (positionArray[x][y].getType() == Type.EMPTY && !goalFlag && checkAroundPos(x, y)) {
                goalFlag = true;
                positionArray[x][y].setParams(x, y, designList.getGoal(), Type.GOAL);
                gameGoal = new Position(x, y, designList.getGoal(), Type.GOAL);
            }
            if (positionArray[x][y].getType() == Type.EMPTY && goalFlag && checkWayToGoal(x, y)) {
                playerFlag = true;
                positionArray[x][y].setParams(x, y, designList.getPlayer(), Type.PLAYER);
                player = new Player(positionArray[x][y], gameGoal);
            }
        }
        if ((!goalFlag || !playerFlag) && exitRecurse > 0) {
            clearCard();
            generateWallsAndEnemies();
            generateGoalAndPlayer(--exitRecurse);
        }
        return exitRecurse;
    }

    public void positionCardBySymbolArray(){
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++){
                symbolArray[i][j] = positionArray[i][j].getSymbol();
            }
        }
    }

    private void searchWay(int x, int y){
        if (x > 0 && y > 0 && x < size && y < size){
            searchWay(x, y +1);
        }
    }

    private boolean checkWayToGoal(int x, int y) {

        return true;
    }

    private boolean checkAroundPos(int x, int y) {
        if (positionArray[x + 1][y].getType() == Type.EMPTY ||
                positionArray[x - 1][y].getType() == Type.EMPTY ||
                positionArray[x][y + 1].getType() == Type.EMPTY ||
                positionArray[x][y - 1].getType() == Type.EMPTY)
            return true;
        else return false;
    }

    public void generateCard(){
        generateEmptyCard();
        generateWallsAndEnemies();
        if (generateGoalAndPlayer(size) == 0)
            throw new IllegalParametersException("Can't make good card. :(\nPlease, change params and try one more time!");
    }

    public void printCard(){
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++){
                Color color = positionArray[i][j].getColor();
                System.out.print(colorize(String.valueOf(positionArray[i][j].getSymbol()), WHITE_BACK(),
                        BACK_COLOR(color.getRed(), color.getGreen(),
                                color.getBlue())));
            }
            System.out.println();
        }
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
