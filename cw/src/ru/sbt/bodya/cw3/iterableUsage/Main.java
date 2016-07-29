package ru.sbt.bodya.cw3.iterableUsage;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        final Player[] players = new Player[3];
        final Team team;


        int i = 0;


        for (i = 0; i < 3; i++) {
            final String tmp = "Player" + i;
            players[i] = new Player(tmp);
        }

        team = new Team(players);

//        Первый способ
//        for (Player player: team) {
//            System.out.printf("Player name: %s\n", player.getName());
//        }

        final Iterator<Player> playerIterator = team.iterator();

        while (playerIterator.hasNext()) {
            final Player player = playerIterator.next();
            System.out.printf("Player name: %s\n", player.getName());
        }
    }
}
