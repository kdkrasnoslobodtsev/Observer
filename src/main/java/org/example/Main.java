package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<GameInfo> allGames = objectMapper.readValue(new File("JSON\\games.json"), new TypeReference<ArrayList<GameInfo>>() {});
        ArrayList<Gamer> gamers = objectMapper.readValue(new File("JSON\\gamers.json"), new TypeReference<ArrayList<Gamer>>() {});
        SteamMarket steam = new SteamMarket(allGames);
        for (Gamer gamer: gamers) {
            steam.addObserver(gamer);
        }
        steam.Discount("Atomic Heart", 0.33);
        System.out.println();
        sleep(2000);
        steam.Discount("God of War", 0.4);
        System.out.println();
        sleep(2000);
        steam.Discount("Witcher III: Wild Hunt", 0.35);
        System.out.println();
        sleep(2000);
        steam.Discount("Metro: Exodus", 0.4);
    }
}