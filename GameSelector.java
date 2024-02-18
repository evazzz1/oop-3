package org.example.lesson3_1;
import java.util.Scanner;

import static org.example.lesson3_1.Logg.addToLog;

public class GameSelector {
    public AbstractGame selectGameMode() {
        Scanner scanner = new Scanner(System.in);
        addToLog("Добро пожаловать в игру! \n" +
                "Для перезапуска нажмите restart \n" +
                "Для паузы нажмите pause\n" +
                "Чтобы выйти из паузы нажмите continue \n" +
                "Выберите режим игры: \nЦифры - нажмите 1 \n" +
                "Английский алфавит - нажмите 2\n" +
                "Русский алфавит - нажмите 3\n");
        String reg = scanner.nextLine();
        addToLog(reg);
        switch (reg) {
            case "1":
                return new NumberGame();
            case "2":
                return new EngGame();
            case "3":
                return new RusGame();
            default:
                addToLog("Неправильный ввод");
                return null;
        }
    }
}