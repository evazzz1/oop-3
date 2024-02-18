package org.example.lesson3_1;

public class Answer {

    private int bull;
    private int cow;
    private int maxTry;

    public Answer(int bull, int cow, int maxTry) {
        this.bull = bull;
        this.cow = cow;
        this.maxTry = maxTry;
    }

    @Override
    public String toString() {
        return "Вывод " + cow + " коровы " + bull + " быка осталось " + maxTry + " попытки";
    }
}