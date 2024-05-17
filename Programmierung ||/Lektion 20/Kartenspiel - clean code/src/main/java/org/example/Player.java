package org.example;

import java.util.ArrayList;
public class Player
{
    public static ArrayList<String> namesPlayers = new ArrayList<>();
    String name;

    public Player(String name)
    {
        this.name = name;
        add(name);
    }
    private static void add(String name)
    {
        namesPlayers.add(name);
    }

}
