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
 * Created by Adrian on 7/5/2015.
 */
public class Genre {

  private final String name;
  private final long id;

  private Genre(Builder builder) {
    name = builder.name;
    id = builder.id;
  }

  public String getName() {
    return name;
  }

  public long getId() {
    return id;
  }

  public static final class Builder {
    private final String name;
    private final long id;

    public Builder(String name, long id) {
      this.name = name;
      this.id = id;
    }

    public Genre build() {
      return new Genre(this);
    }
  }
}
