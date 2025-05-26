package com.year2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import com.example.Puzzle;
import com.example.PuzzleInput;

public class Day3 implements Puzzle {

 
  private ArrayList<String> puzzleInputArray;
  private HashMap<String, Integer> presentsInHouseCoord = new HashMap<>();
  

  public Day3() throws Exception {
    PuzzleInput puzzleInput = new PuzzleInput(2015, 3);
    String responseString = puzzleInput.getPuzzleInput().trim();
    String[] inputStrings = responseString.split("");
    puzzleInputArray = new ArrayList<>(Arrays.asList(inputStrings));
  }

  public int solvePuzzle() {
    // Santa's position
    int santaX = 0, santaY = 0;
    // Robo-Santa's position
    int roboX = 0, roboY = 0;
    presentsInHouseCoord.clear();
    // Both start at the same house
    presentsInHouseCoord.put("0,0", 1);

    for (int i = 0; i < puzzleInputArray.size(); i++) {
        String direction = puzzleInputArray.get(i);
        // Decide who moves
        if (i % 2 == 0) { // Santa's turn
            if (direction.equals("^")) santaY++;
            else if (direction.equals("v")) santaY--;
            else if (direction.equals(">")) santaX++;
            else if (direction.equals("<")) santaX--;
            String coord = santaX + "," + santaY;
            presentsInHouseCoord.put(coord, presentsInHouseCoord.getOrDefault(coord, 0) + 1);
        } else { // Robo-Santa's turn
            if (direction.equals("^")) roboY++;
            else if (direction.equals("v")) roboY--;
            else if (direction.equals(">")) roboX++;
            else if (direction.equals("<")) roboX--;
            String coord = roboX + "," + roboY;
            presentsInHouseCoord.put(coord, presentsInHouseCoord.getOrDefault(coord, 0) + 1);
        }
    }
    return presentsInHouseCoord.size();
}
}
