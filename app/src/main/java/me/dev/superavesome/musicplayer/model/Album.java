package me.dev.superavesome.musicplayer.model;

/**
 * Created by Vardan sharma on 21/5/16.
 */
public class Album {
  private final String artistName;
  private final String albumName;
  private final long id;

  private Album(Builder builder) {
    artistName = builder.artistName;
    albumName = builder.albumName;
    id = builder.id;
  }

  public String getArtistName() {
    return artistName;
  }

  public String getAlbumName() {
    return albumName;
  }

  public long getId() {
    return id;
  }

  @Override public String toString() {
    return "Artist{" +
        "artistName='" + artistName + '\'' +
        ", albumName='" + albumName + '\'' +
        ", id='" + id + '\'' +
        '}';
  }

  public static final class Builder {
    private String artistName;
    private String albumName;
    private long id;

    public Builder() {
    }

    public Builder artistName(String val) {
      artistName = val;
      return this;
    }

    public Builder albumName(String val) {
      albumName = val;
      return this;
    }

    public Builder id(long val) {
      id = val;
      return this;
    }

    public Album build() {
      return new Album(this);
    }
  }
}
