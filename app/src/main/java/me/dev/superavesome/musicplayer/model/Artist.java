package me.dev.superavesome.musicplayer.model;

/**
 * Created by Vardan sharma on 22/5/16.
 */
public final class Artist {
    private final String name;
    private final String id;
    private final String albumId;
    private final int numTracks;
    private final int numAlbums;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getNumTracks() {
        return numTracks;
    }

    public int getNumAlbums() {
        return numAlbums;
    }

    public String getAlbumId() {
        return albumId;
    }

    private Artist(Builder builder) {
        name = builder.name;
        id = builder.id;
        albumId = builder.albumId;
        numTracks = builder.numTracks;
        numAlbums = builder.numAlbums;
    }

    public static final class Builder {
        private String name;
        private String id;
        private String albumId;
        private int numTracks;
        private int numAlbums;

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

        public Builder albumId(String val) {
            albumId = val;
            return this;
        }

        public Builder numTracks(int val) {
            numTracks = val;
            return this;
        }

        public Builder numAlbums(int val) {
            numAlbums = val;
            return this;
        }

        public Artist build() {
            return new Artist(this);
        }
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", albumId='" + albumId + '\'' +
                ", numTracks=" + numTracks +
                ", numAlbums=" + numAlbums +
                '}';
    }
}
