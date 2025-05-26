package com.year2015;

import org.apache.commons.codec.digest.DigestUtils;

import com.example.Puzzle;

public class Day4 implements Puzzle {
    String puzzleInput = "iwrupvqb"; 
    int puzzlePart1 = 5;
    long lowestPostiveNum = 0;

    public int solvePuzzle(){
        StringBuilder sb = new StringBuilder(puzzleInput);
        while (true) {
            sb.append(lowestPostiveNum);
            String hash = DigestUtils.md5Hex(sb.toString());
            if (hash.startsWith("000000")) {
                break;
            }
            lowestPostiveNum++;
            sb.setLength(puzzleInput.length()); 
        }
        return (int) lowestPostiveNum;
    }
}
