package se.roshult.devtest;

import lombok.extern.slf4j.Slf4j;
import se.roshult.devtest.game.Game;
import se.roshult.devtest.model.Result;

import java.text.DecimalFormat;

import static se.roshult.devtest.model.Result.WIN;

@Slf4j
public class TvShow {

    private final static int DEFAULT_NUMBER_OF_GAMES = 10000;
    private static final DecimalFormat WIN_RATE_FORMAT = new DecimalFormat("0.00");
    private static int WINS=0;

    public static void main (String ...args){
        int nrOfGames = DEFAULT_NUMBER_OF_GAMES;
        if (args.length > 0 && args[0] != null) {
            try {
                nrOfGames = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                log.error("{} is not a valid number, pls try again with a different input", args[0]);
                throw e;
            }
        }
        runGamesWithoutChangingTheBox(nrOfGames);
        resetResult();
        runGamesAndChangeTheBox(nrOfGames);
    }

    private static void runGamesAndChangeTheBox(int nrOfGames) {
        boolean changeBox = true;
        runGames(nrOfGames, changeBox);
        printResult(nrOfGames, changeBox);
    }

    private static void runGamesWithoutChangingTheBox(int nrOfGames) {
        boolean changeBox = false;
        runGames(nrOfGames, changeBox);
        printResult(nrOfGames, changeBox);
    }

    private static void runGames(int nrOfGames, boolean changeBox) {
        log.info("Run {} of games where player {} change box after the host reveals an empty one",
                nrOfGames,
                changeBox ? "do" : "do not");
        for(int i = 1; i<= nrOfGames; i++) {
            Game game = new Game();
            Result result = game.start(changeBox);
            if(result.equals(WIN)){
                WINS++;
            };
        }
    }

    private static void printResult(int nrOfGames, boolean changeBox) {
        log.info("Won {} out of {} games, where player {} change box",
                WINS,
                nrOfGames,
                changeBox ? "did": "did not");
        double winRate = ((double) WINS / (double) nrOfGames)*100;
        log.info("The player had a win rate at {}%", WIN_RATE_FORMAT.format(winRate));

    }

    private static void resetResult() {
        WINS=0;
    }
}
