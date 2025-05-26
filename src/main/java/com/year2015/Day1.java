package com.year2015;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.Puzzle;
import com.example.PuzzleInput;

public class Day1 implements Puzzle {
    private ArrayList<String> puzzleInputArray;
    private int floor_level = 0;

    public Day1() throws Exception {
        PuzzleInput puzzleInput = new PuzzleInput(2015, 1);
        String[] inputStrings = puzzleInput.getPuzzleInput().split("");
        puzzleInputArray = new ArrayList<>(Arrays.asList(inputStrings));
    }

    public int solvePuzzle() {
        for (int i = 0; i < puzzleInputArray.size(); i++) {
            String ch = puzzleInputArray.get(i);
            // Example: check if character is '(' or ')'
            if (floor_level == -1) {
                return i;
            } else if ("(".equals(ch)) {
                floor_level++;
            } else if (")".equals(ch)) {
                floor_level--;
            }
        }
        return floor_level;
    }

}
