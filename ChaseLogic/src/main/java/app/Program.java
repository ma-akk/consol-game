package app;

import logic.StepDirection;

import java.util.Random;

public class Program {
    int size = 10;
    char[][] symbolArray = new char[size + 2][size + 2];
    int wallsCount = 50;
    int enemiesCount = 1;
    char empty = ' ';
    char enemy = 'X';
    char wall = '#';
    char player = 'o';

    public void printSymbolCard() {
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++) {
                System.out.print(symbolArray[i][j]);
            }
            System.out.println();
        }
    }

    private boolean checkEmptySymbol(char empty){
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++){
                if (symbolArray[i][j] == empty)
                    return true;
            }
        }
        return false;
    }

    public void generateEmptyCard(){
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++) {
                if (i == 0 || j == 0 || i == size + 1 || j == size + 1) {
                    symbolArray[i][j] = wall;
                } else {
                    symbolArray[i][j] = empty;
                }
            }
        }
    }

    public void generateWallsAndEnemies() {
        generateEmptyCard();
        Random rand = new Random(System.currentTimeMillis());
        int x;
        int y;
        int exitLoop = size * size * size;
        int checkWalls = wallsCount;
        int checkEnemies = enemiesCount;
        while (checkWalls + checkEnemies > 0 && exitLoop-- > 0) {
            x = rand.nextInt(size) + 1;
            y = rand.nextInt(size) + 1;
            if (symbolArray[x][y] == empty) {
                if (exitLoop % 2 == 0 && checkWalls > 0) {
                    checkWalls--;
                    symbolArray[x][y] = wall;
                } else if (checkEnemies > 0) {
                    symbolArray[x][y] = enemy;
                    checkEnemies--;
                }
            }
        }
        boolean flag = false;
        while (checkEmptySymbol(empty) && !flag){
            x = rand.nextInt(size) + 1;
            y = rand.nextInt(size) + 1;
            if (symbolArray[x][y] == empty) {
                symbolArray[x][y] = player;
                flag = true;
            }
        }
    }


    public static void main(String[] args){
        Program p = new Program();

        p.generateWallsAndEnemies();
        p.printSymbolCard();
        StepDirection enemyXY = StepDirection.searchEnemy(p.symbolArray, p.enemy);
        int x = enemyXY.getX();
        int y = enemyXY.getY();
        int pX = enemyXY.searchPlayer(p.symbolArray, p.player).getX();
        int pY = enemyXY.searchPlayer(p.symbolArray, p.player).getY();
        while (x != pX || y != pY) {
            System.out.println(x + " " + y);
            enemyXY.getStepDirection(x, y, p.symbolArray, p.enemy, p.player, p.empty);
            p.symbolArray[x][y] = p.empty;
            p.symbolArray[enemyXY.getX()][enemyXY.getY()] = p.enemy;
            p.printSymbolCard();
            System.out.println(enemyXY.getX() + " " + enemyXY.getY());
            x = enemyXY.getX();
            y = enemyXY.getY();
        }
    }
}
