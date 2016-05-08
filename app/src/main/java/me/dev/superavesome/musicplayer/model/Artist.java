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

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

/**
 * Created by Vardan sharma
 */
public class Artist extends MediaObject {
  private final String artistName;
  private final String artistBio;

  private final List<Album> artistAlbums;
  private final List<Song> artistSongs;

  private final Bitmap artistImage;

  private Artist(Builder builder) {
    data = builder.data;
    id = builder.id;
    locked = builder.locked;
    setPosInList(builder.posInList);
    artistName = builder.artistName;
    artistBio = builder.artistBio;
    artistAlbums = builder.artistAlbums;
    artistSongs = builder.artistSongs;
    artistImage = builder.artistImage;
  }

  @Override protected Uri getBaseUri() {
    return MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;
  }

  public String getName() {
    return artistName;
  }

  public String getBio() {
    return artistBio;
  }

  public Bitmap getArtistImage() {
    return artistImage;
  }

  public List<Album> getArtistAlbums() {
    return artistAlbums;
  }

  public List<Song> getArtistSongs() {
    return artistSongs;
  }

  public static final class Builder {
    private MediaMetadataCompat data;
    private long id;
    private boolean locked;
    private int posInList;
    private final String artistName;
    private final String artistBio;
    private final List<Album> artistAlbums;
    private final List<Song> artistSongs;
    private final Bitmap artistImage;

    public Builder(String artistName, String artistBio, List<Album> artistAlbums,
        List<Song> artistSongs, Bitmap artistImage) {
      this.artistName = artistName;
      this.artistBio = artistBio;
      this.artistAlbums = artistAlbums;
      this.artistSongs = artistSongs;
      this.artistImage = artistImage;
    }

    public Builder data(MediaMetadataCompat val) {
      data = val;
      return this;
    }

    public Builder id(long val) {
      id = val;
      return this;
    }

    public Builder locked(boolean val) {
      locked = val;
      return this;
    }

    public Builder posInList(int val) {
      posInList = val;
      return this;
    }

    public Artist build() {
      return new Artist(this);
    }
  }
}
