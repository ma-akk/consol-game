package edu.school21.game;

import com.beust.jcommander.JCommander;

public class Logic {

    private JParserCmd parser = new JParserCmd();
    private DesignList designList;
    private Card cardGame;
    private Player player;
    private Enemy[] enemies;
    private Position[] enemiesPos;

    public void start(String[] args) {
        parseParamsGame(args);
        initParamsGame();
        while (true) {
            cardGame.printCard();
            cardGame.changePosition(Type.PLAYER, cardGame.getPlayerPosition(),
                    player.doStep(player.getStepSignal()));
            for (int i = 0; i < enemies.length; i++) {
                cardGame.changePosition(Type.ENEMY, cardGame.getEnemiesPosition()[i],
                        enemies[i].doStep(enemies[i].getStepDirection(
                                cardGame.getSymbolArray(), parser.getEmptyChar())));
                cardGame.positionCardBySymbolArray();
                if (enemies[i].getCharacterGoal() == enemies[i].getCharacterPos()) {
                    enemies[i].getMessageFinish("YOU LOSE! FAIL!");
                }
            }
            if (player.getCharacterGoal() == player.getCharacterPos()) {
                player.getMessageFinish("YOU WIN! CONGRATULATION!");
            }
        }
    }

    public void initParamsGame() {
        designList = new DesignList(new Design(parser.getEnemyColor(), parser.getEnemyChar()),
                new Design(parser.getPlayerColor(), parser.getPlayerChar()),
                new Design(parser.getWallColor(), parser.getWallChar()),
                new Design(parser.getGoalColor(), parser.getGoalChar()),
                new Design(parser.getEmptyColor(), parser.getEmptyChar()));
        cardGame = new Card(designList, parser.getFieldSize(),
                parser.getEnemiesCount(), parser.getWallsCount());
        player = new Player(cardGame.getPlayerPosition(), cardGame.getGameGoal());
        enemies = new Enemy[parser.getEnemiesCount()];
        enemiesPos = cardGame.getEnemiesPosition();
        for (int i = 0; i < parser.getEnemiesCount(); i++) {
            enemies[i].setCharacterPos(enemiesPos[i]);
            enemies[i].setCharacterGoal(player.getCharacterGoal());
        }
    }

    public void parseParamsGame(String[] args) {
        JCommander.newBuilder().addObject(parser)
                .build()
                .parse(args);
        parser.parseProps();
    }
}
