package edu.school21.game;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

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

    JParserCmd parser = new JParserCmd();

//        JCommander.newBuilder().addObject(helper)
//                .build()
//                .parse(args);
}
