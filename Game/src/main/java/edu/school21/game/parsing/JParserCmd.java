package edu.school21.game.parsing;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.awt.Color.*;

@Parameters(separators = "=")
public class JParserCmd {

    @Parameter(
            names = "--enemiesCount",
            description = "number of enemies",
            required = true
    )
    private Integer enemiesCount;

    @Parameter(
            names = "--wallsCount",
            description = "number of obstacles",
            required = true
    )
    private Integer wallsCount;

    @Parameter(
            names = "--size",
            description = "field size",
            required = true
    )
    private Integer fieldSize;

    @Parameter(
            names = "--profile",
            description = "profile game",
            required = true
    )
    private String profile;
    private String enemyChar;
    private String playerChar;
    private String wallChar;
    private String goalChar;
    private String emptyChar;
    private String enemyColor;
    private String playerColor;
    private String wallColor;
    private String goalColor;
    private String emptyColor;

    public Integer getEnemiesCount() {
        return enemiesCount;
    }

    public Integer getWallsCount() {
        return wallsCount;
    }

    public Integer getFieldSize() {
        return fieldSize;
    }

    public String getProfile() {
        return profile;
    }

    public char getEnemyChar() {
        return enemyChar.charAt(0);
    }

    public char getPlayerChar() {
        return playerChar.charAt(0);
    }

    public char getWallChar() {
        return wallChar.charAt(0);
    }

    public char getGoalChar() {
        return goalChar.charAt(0);
    }

    public char getEmptyChar() {
        if (emptyChar.equals(""))
            emptyChar = " ";
        return emptyChar.charAt(0);
    }

    public Color getEnemyColor() {
        return chooseColor(enemyColor);
    }

    public Color getPlayerColor() {
        return chooseColor(playerColor);
    }

    public Color getWallColor() {
        return chooseColor(wallColor);
    }

    public Color getGoalColor() {
        return chooseColor(goalColor);
    }

    public Color getEmptyColor() {
        return chooseColor(emptyColor);
    }

    public void parseProps(String filename) {
        FileInputStream fileInput;

        Properties property = new Properties();

        try {
            fileInput = new FileInputStream(filename);
            property.load(fileInput);
            enemyChar = property.getProperty("enemy.char");
            playerChar = property.getProperty("player.char");
            wallChar = property.getProperty("wall.char");
            goalChar = property.getProperty("goal.char");
            emptyChar = property.getProperty("empty.char");
            enemyColor = property.getProperty("enemy.color");
            playerColor = property.getProperty("player.color");
            wallColor = property.getProperty("wall.color");
            goalColor = property.getProperty("goal.color");
            emptyColor = property.getProperty("empty.color");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public String generateFileNameProps() {
        return "src/main/resources/application-" +
                profile + ".properties";
    }

    private Color chooseColor(String colorName) {

        Color color = new Color(255, 255, 255);

        switch (colorName) {
            case "RED": color = RED;
                break;
            case "BLUE": color = BLUE;
                break;
            case "YELLOW": color = YELLOW;
                break;
            case "BLACK": color = BLACK;
                break;
            case "GREEN": color = GREEN;
                break;
            case "GRAY": color = GRAY;
                break;
            case "ORANGE": color = ORANGE;
                break;
            case "CYAN": color = CYAN;
                break;
            case "MAGENTA": color = MAGENTA;
                break;
            case "DARK_GRAY": color = DARK_GRAY;
                break;
            case "LIGHT_GRAY": color = LIGHT_GRAY;
                break;
            case "PINK": color = PINK;
                break;
            default: color = WHITE;
                break;
        }
        return color;
    }

}
