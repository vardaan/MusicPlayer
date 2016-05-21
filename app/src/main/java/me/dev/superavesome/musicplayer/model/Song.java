/*
 * Copyright 2016 Substance Mobile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.dev.superavesome.musicplayer.model;

/**
 * Model for the Song
 */
public class Song {

  private final String duration;
  private final String artistId;
  private final String artist;
  private final String albumId;
  private final String album;
  private final String genre;
  private final String path;
  private final String title;

  private Song(Builder builder) {
    duration = builder.duration;
    artistId = builder.artistId;
    artist = builder.artist;
    albumId = builder.albumId;
    album = builder.album;
    genre = builder.genre;
    path = builder.path;
    title = builder.title;
  }

  public String getTitle() {
    return title;
  }

  public String getPath() {
    return path;
  }

  public String getDuration() {
    return duration;
  }

  public String getArtistId() {
    return artistId;
  }

  public String getArtist() {
    return artist;
  }

  public String getAlbumId() {
    return albumId;
  }

  public String getAlbum() {
    return album;
  }

  public String getGenre() {
    return genre;
  }

  @Override public String toString() {
    return "Song{" +
        "duration='" + duration + '\'' +
        ", artistId='" + artistId + '\'' +
        ", artist='" + artist + '\'' +
        ", albumId='" + albumId + '\'' +
        ", album='" + album + '\'' +
        ", genre='" + genre + '\'' +
        ", path='" + path + '\'' +
        '}';
  }

  public static final class Builder {
    private String duration;
    private String artistId;
    private String artist;
    private String albumId;
    private String album;
    private String genre;
    private String path;
    private String title;

    public Builder() {
    }

    public Builder duration(String val) {
      duration = val;
      return this;
    }

    public Builder artistId(String val) {
      artistId = val;
      return this;
    }

    public Builder artist(String val) {
      artist = val;
      return this;
    }

    public Builder albumId(String val) {
      albumId = val;
      return this;
    }

    public Builder album(String val) {
      album = val;
      return this;
    }

    public Builder genre(String val) {
      genre = val;
      return this;
    }

    public Builder path(String val) {
      path = val;
      return this;
    }

    public Builder title(String val) {
      title = val;
      return this;
    }

    public Song build() {
      return new Song(this);
    }
  }
}