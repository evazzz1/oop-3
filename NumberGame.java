package org.example.lesson3_1;

import java.util.ArrayList;
import java.util.List;

public class NumberGame extends AbstractGame {
    @Override
    protected List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }
}
