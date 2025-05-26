package com.year2015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.Puzzle;
import com.example.PuzzleInput;

public class Day2 implements Puzzle {
    private int totalArea = 0;

    private List<List<Integer>> puzzleInputArray = new ArrayList<>();

    public Day2() throws Exception {
        PuzzleInput puzzleInput = new PuzzleInput(2015, 2);
        String responseString = puzzleInput.getPuzzleInput().trim();
        String[] inputStrings = responseString.split("\n");
        for (String line : inputStrings) {
            String[] parts = line.trim().split("x");
            List<Integer> dimensions = new ArrayList<>();
            for (String dimension : parts) {
                dimensions.add(Integer.parseInt(dimension));
            }
            puzzleInputArray.add(dimensions);
        }
    }

    public int solvePuzzle() {
        for (List<Integer> dimension : puzzleInputArray) {
            int area = getArea(dimension);
            int perimeter = getSmallestPerimeter(dimension);
            totalArea += area + perimeter;
        }
        return totalArea;
    }


    private int getArea(List<Integer> dimension) {
        int area;
        int length = dimension.get(0);
        int width = dimension.get(1);
        int height = dimension.get(2);
        area = length * width * height;
        return area;
    }

    private int getSmallestPerimeter(List<Integer> dimensions) {
        Collections.sort(dimensions);
        int length = dimensions.get(0);
        int width = dimensions.get(1);
        return 2 * (length + width);
    }
 
}
