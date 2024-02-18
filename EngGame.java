package org.example.lesson3_1;

import java.util.ArrayList;
import java.util.List;

public class EngGame extends AbstractGame {
    @Override
    protected List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            result.add(String.valueOf((char) i));
        }
        return result;
    }
}
