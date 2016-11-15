package me.dev.superavesome.musicplayer.model;

/**
 * Created by vardansharma on 15/11/16.
 */

public final class Genre {
    private final String name;
    private final String id;
    private final int numOfArtist;
    private final int numOfTracks;

    private Genre(Builder builder) {
        name = builder.name;
        id = builder.id;
        numOfArtist = builder.numOfArtist;
        numOfTracks = builder.numOfTracks;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getNumOfArtist() {
        return numOfArtist;
    }

    public int getNumOfTracks() {
        return numOfTracks;
    }

    public static final class Builder {
        private String name;
        private String id;
        private int numOfArtist;
        private int numOfTracks;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder numOfArtist(int val) {
            numOfArtist = val;
            return this;
        }

        public Builder numOfTracks(int val) {
            numOfTracks = val;
            return this;
        }

        public Genre build() {
            return new Genre(this);
        }
    }
}
