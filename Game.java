package org.example.lesson3_1;

public interface Game {

    void start(int sizeWord, int maxTry);

    Answer inputValue(String value);

    GameStatus getGameStatus();
}
