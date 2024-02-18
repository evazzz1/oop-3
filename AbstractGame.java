package org.example.lesson3_1;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.example.lesson3_1.Logg.addToLog;

public abstract class AbstractGame implements Game {

    private int sizeWord;
    private int maxTry;
    private String computerWord;
    private GameStatus status = GameStatus.INIT;

    private String generateWord() {
        List<String> alf = generateCharList();
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sizeWord; i++) {
            int randIndex = random.nextInt(alf.size());
            result.append(alf.get(randIndex));
            alf.remove(randIndex);
        }
        return result.toString();
    }

   protected abstract List<String> generateCharList();
    public void setGameStatus(GameStatus gameStatus) {
        this.status = gameStatus;
    }

    @Override
    public void start(int sizeWord, int maxTry) {
        this.sizeWord = sizeWord;
        computerWord = generateWord();
        this.maxTry = maxTry;
        status = GameStatus.PLAY;
    }
    public void restartGame() {
        computerWord = generateWord();
        System.out.println(computerWord);
        maxTry = 3;
        status = GameStatus.PLAY;
        addToLog("вы перезапустиили игру");
    }
    public void pauseGame() {
        String word;
        do {
            addToLog("игра на паузе, если хотите продолжить нажмите continue");
            Scanner scanner = new Scanner(System.in);
            word = scanner.nextLine();
            addToLog(word);

        }
        while (!word.equals("continue"));
        addToLog("продолжаем игру");
        status = GameStatus.PLAY;
    }

    @Override
    public Answer inputValue(String value) {
        addToLog(value);
        if (status != GameStatus.PLAY) {
            addToLog("вы не начали игру!");
            throw new RuntimeException();
        }

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < computerWord.length(); i++) {
            if (computerWord.charAt(i) == value.charAt(i)) {
                bulls++;
                cows++;
            } else if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                cows++;
            }
        }
        maxTry--;
        if (maxTry == 0) {
            status = GameStatus.LOOSE;
        }
        if (bulls == sizeWord) {
            status = GameStatus.WIN;
        }
        return new Answer(bulls, cows, maxTry);
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }

}
