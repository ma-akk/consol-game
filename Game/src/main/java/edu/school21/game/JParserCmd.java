package edu.school21.game;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcdp.color.api.Ansi;
import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JParserCmd {

//    @Parameters(separators = "=")
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
        return emptyChar.charAt(0);
    }

    public Ansi.BColor getEnemyColor() {
        return Ansi.BColor.valueOf(enemyColor);
    }

    public Ansi.BColor getPlayerColor() {
        return Ansi.BColor.valueOf(playerColor);
    }

    public Ansi.BColor getWallColor() {
        return Ansi.BColor.valueOf(wallColor);
    }

    public Ansi.BColor getGoalColor() {
        return Ansi.BColor.valueOf(goalColor);
    }

    public Ansi.BColor getEmptyColor() {
        return Ansi.BColor.valueOf(emptyColor);
    }

    public void parseProps() {

        FileInputStream fileInput;

        Properties property = new Properties();

        try {
            //JParserCmd.class.getResource("/resources/image.bmp")
            fileInput = new FileInputStream("src/main/resources/application.properties");
            property.load(fileInput);
            enemyChar = property.getProperty("enemy.char");
            playerChar = property.getProperty("playerChar");
            wallChar = property.getProperty("wallChar");
            goalChar = property.getProperty("goalChar");
            emptyChar = property.getProperty("emptyChar");
            enemyColor = property.getProperty("enemyColor");
            playerColor = property.getProperty("playerColor");
            wallColor = property.getProperty("wallColor");
            goalColor = property.getProperty("goalColor");
            emptyColor = property.getProperty("emptyColor");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }
}
