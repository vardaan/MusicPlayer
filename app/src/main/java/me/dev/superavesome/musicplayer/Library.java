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

package me.dev.superavesome.musicplayer;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import me.dev.superavesome.musicplayer.model.Song;
import me.dev.superavesome.musicplayer.tasks.SongsTask;

public class Library {
  public static volatile Context context;
  private static volatile List<Song> mSongs = new ArrayList<>();
  private static volatile SongsTask mSongsTask;

  public Library(Context context) {
    Library.context = context.getApplicationContext();

    //Creates tasks
    mSongsTask = new SongsTask(context);

    //Adds all non-UI listeners to tasks
    mSongsTask.addListener(new Loader.TaskListener<Song>() {
      @Override public void onOneLoaded(Song item, int pos) {
        updateLinks();
      }

      @Override public void onCompleted(List<Song> result) {
        mSongs = result;
      }
    });
  }

  public static void setContext(Context cxt) {
    context = cxt;
  }

  ///////////////////////////////////////////////////////////////////////////
  // Builds the media library
  ///////////////////////////////////////////////////////////////////////////

  @SuppressWarnings("all") public static void build() {

    mSongsTask.run();
  }

  private static void updateLinks() {
    //TODO
  }

  ///////////////////////////////////////////////////////////////////////////
  // Update Listener from MediaStore
  ///////////////////////////////////////////////////////////////////////////

  public static void registerMediaStoreListeners() {
    mSongsTask.registerMediaStoreListener();
  }

  public static void unregisterMediaStoreListeners() {
    mSongsTask.unregisterMediaStoreListener();
  }

  ///////////////////////////////////////////////////////////////////////////
  // Helper methods for adding listeners to tasks
  ///////////////////////////////////////////////////////////////////////////

  public static void registerSongListener(Loader.TaskListener<Song> songListener) {
    mSongsTask.addListener(songListener);
  }

  public static List<Song> getSongs() {
    return mSongs;
  }

  ///////////////////////////////////////////////////////////////////////////
  // Methods for finding a media object by ID
  ///////////////////////////////////////////////////////////////////////////

  @Nullable public static Song findSongById(long id) {
    for (Song song : getSongs()) if (song.getID() == id) return song;
    return null;
  }

  @Nullable public static Song findSongByUri(Uri uri) {
    for (Song song : getSongs()) if (song.getUri() == uri) return song;
    return null;
  }
}
