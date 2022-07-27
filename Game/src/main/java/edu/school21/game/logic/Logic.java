package edu.school21.game.logic;

import com.beust.jcommander.JCommander;
import edu.school21.game.objects.card.Card;
import edu.school21.game.objects.card.Design;
import edu.school21.game.objects.card.DesignList;
import edu.school21.game.objects.card.Position;
import edu.school21.game.objects.characters.Enemy;
import edu.school21.game.objects.characters.Player;
import edu.school21.game.objects.enums.Type;
import edu.school21.game.parsing.JParserCmd;

import java.util.Scanner;

public class Logic {

    private JParserCmd parser = new JParserCmd();
    Scanner scan = new Scanner(System.in);
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
                    player.doStep(player.getStepSignal(parser.getProfile())));
            if (player.getCharacterGoal().equals(player.getCharacterPos())) {
                cardGame.printCard();
                player.getMessageFinish("YOU WIN! CONGRATULATION!");
            }
            cardGame.positionCardBySymbolArray();
            for (int i = 0; i < enemies.length; i++) {
                if (parser.getProfile().equals("dev")) {
                    int flag = scan.nextInt();
                    cardGame.printCard();
                }
                enemies[i].setCharacterGoal(player.getCharacterPos());
                cardGame.changePosition(Type.ENEMY, cardGame.getEnemiesPosition()[i],
                        enemies[i].doStep(enemies[i].getStepDirection(
                                cardGame.getSymbolArray(), parser.getEmptyChar())));
                cardGame.positionCardBySymbolArray();
                if (enemies[i].getCharacterGoal().equals(enemies[i].getCharacterPos())) {
                    cardGame.printCard();
                    enemies[i].getMessageFinish("YOU LOSE! FAIL!");
                }
            }
            if (parser.getProfile().equals("production")) {
                System.out.print("\033[H\033[J");
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
            enemies[i] = new Enemy(enemiesPos[i]);
            enemies[i].setCharacterGoal(player.getCharacterPos());
        }
    }

    public void parseParamsGame(String[] args) {
        JCommander.newBuilder().addObject(parser)
                .build()
                .parse(args);
        parser.parseProps(parser.generateFileNameProps());
    }
}
