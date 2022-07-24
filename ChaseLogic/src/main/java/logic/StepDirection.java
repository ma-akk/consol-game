package logic;

import java.util.Random;

public class StepDirection {
    private int x;
    private int y;

    public StepDirection() {
    }

    public StepDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static StepDirection searchPlayer(char[][] card, char player){
        StepDirection ret = new StepDirection();
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++){
                if(card[i][j] == player){
                    ret.setX(i);
                    ret.setY(j);
                    return ret;
                }
            }
        }
        return null;
    }

    public static StepDirection searchEnemy(char[][] card, char enemy){
        StepDirection ret = new StepDirection();
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++){
                if(card[i][j] == enemy){
                    ret.setX(i);
                    ret.setY(j);
                    return ret;
                }
            }
        }
        return null;
    }

    public void getStepDirection(int x, int y, char[][] card, char enemy, char player, char empty){
        Random random = new Random(System.currentTimeMillis());
        if (card[x][y] != enemy || x < 1 || y < 1 || x > card.length - 2 || y > card.length - 2 || enemy == player ||
        player == empty || enemy == empty)
        {
            this.x = -1;
            this.y = -1;
            return;
        }
        StepDirection playXY = searchPlayer(card, player);
        if (playXY == null){
            this.x = -1;
            this.y = -1;
            return;
        }
        if (x == playXY.getX() && y == playXY.getY()) {
            this.x = x;
            this.y = y;
            return;
        }
        if (x == playXY.getX() && y > playXY.getY() && (card[x][y - 1] == empty || card[x][y - 1] == player)){
            y--;
        } else if (x == playXY.getX() && y < playXY.getY() && (card[x][y + 1] == empty || card[x][y + 1] == player)){
            y++;
        } else if (y == playXY.getY() && x < playXY.getX() && (card[x + 1][y] == empty || card[x + 1][y] == player)){
            x++;
        } else if (y == playXY.getY() && x > playXY.getX() && (card[x - 1][y] == empty || card[x - 1][y] == player)){
            x--;
        } else if (x >= playXY.getX() && (card[x - 1][y] == empty || card[x - 1][y] == player) ){
            x--;
        } else if (x <= playXY.getX() && (card[x + 1][y] == empty || card[x + 1][y] == player)){
            x++;
        } else if (y >= playXY.getY() && (card[x][y - 1] == empty || card[x][y - 1] == player)){
            y--;
        } else if (y <= playXY.getY() && (card[x][y + 1] == empty || card[x][y + 1] == player)){
            y++;
        }
        this.x = x;
        this.y = y;
    }
}
