package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PuzzleInput {
    private static HttpResponse<String> puzzleInput;
    private String aocSession = EnvConfig.get("AOC_SESSION_COOKIE");
    private String email = EnvConfig.get("EMAIL");

    public PuzzleInput(int year, int day) throws IOException, InterruptedException {
        String url = String.format("https://adventofcode.com/%d/day/%d/input", year, day);
        HttpClient aocClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).header("Cookie", "session=" + aocSession)
                .header("User-Agent", "JavaClient/1.0 " + email).GET().build();
        puzzleInput = aocClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getPuzzleInput() {
        String puzzleInputString = puzzleInput.body();
        return puzzleInputString;
    }

}
