package org.example.lesson3_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Logg {

    private static List<String> ll = new ArrayList<>();
    private Logg() {
    }

    public static void addToLog(String text)
    {
        System.out.println(text);
        ll.add(text);
    }

    public static void printLog()
    {
        System.out.println("Хотите ли вы вывести логирование? Напишите yes, если да");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equals("yes")) {
            System.out.println("\n Вывод всех логов:");
            int i = 1;
            for (String element : ll) {
                System.out.println("лог № \t" + i + ": \t" + element + " \n");
                i++;
            }
        }
    }
}
