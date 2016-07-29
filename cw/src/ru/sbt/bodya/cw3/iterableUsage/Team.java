package ru.sbt.bodya.cw3.iterableUsage;

import java.util.Iterator;

public class Team implements Iterable<Player> {

    private final Player[] players;

    public Team(Player[] players) {
        this.players = players;
    }

    @Override
    public Iterator<Player> iterator() {

        return new PlayerIterator();

    }

    private class PlayerIterator implements Iterator<Player> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return Team.this.players.length > index;
        }

        @Override
        public Player next() {
            final int currentIndex = index;
            return Team.this.players[index++];
        }
    }
}
