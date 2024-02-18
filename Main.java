package org.example.lesson3_1;

import java.util.Scanner;

import static org.example.lesson3_1.Logg.addToLog;
import static org.example.lesson3_1.Logg.printLog;


public class Main {
    public static void main(String[] args) {
        GameSelector gameSelector = new GameSelector();
        AbstractGame abstractGame = gameSelector.selectGameMode();

        if (abstractGame == null) {
            addToLog("вы не выбрали режим");
            return;
        }
        abstractGame.start(4, 3);
        Scanner scanner = new Scanner(System.in);

            while (abstractGame.getGameStatus().equals(GameStatus.PLAY) ||
                    abstractGame.getGameStatus().equals(GameStatus.RESTART)||
                    abstractGame.getGameStatus().equals(GameStatus.PAUSE))
            {
                if (abstractGame.getGameStatus().equals(GameStatus.RESTART)) {
                    abstractGame.restartGame();
                }
                if (abstractGame.getGameStatus().equals(GameStatus.PAUSE)) {
                    abstractGame.pauseGame();
                }
            String word = scanner.nextLine();
                if (word.equals("pause")) {
                    abstractGame.setGameStatus(GameStatus.PAUSE);
                    continue;
                }
                if (word.equals("restart")) {
                    abstractGame.setGameStatus(GameStatus.RESTART);
                }
            else {
                Answer answer = abstractGame.inputValue(word);
                addToLog(String.valueOf(answer));
            }
        }
        if (abstractGame.getGameStatus().equals(GameStatus.WIN)) {
            addToLog("вы победили");
        } else {
            addToLog("вы проиграли");
        }
        printLog();
    }
}
