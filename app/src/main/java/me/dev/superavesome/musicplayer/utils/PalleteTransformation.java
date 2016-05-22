package me.dev.superavesome.musicplayer.utils;

import android.graphics.Bitmap;
import android.support.v4.util.Pools;
import android.support.v7.graphics.Palette;
import com.squareup.picasso.Transformation;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Vardan sharma on 22/5/16.
 * taken from http://jakewharton.com/coercing-picasso-to-play-with-palette/
 * TODO modify it in case of
 */
public class PalleteTransformation implements Transformation {
  private static final Pools.Pool<PalleteTransformation> POOL = new Pools.SynchronizedPool<>(5);
  private static final Map<Bitmap, Palette> CACHE = new WeakHashMap<>();

  public static PalleteTransformation getInstance() {
    PalleteTransformation instance = POOL.acquire();
    return instance != null ? instance : new PalleteTransformation();
  }

  private Palette palette;

  private PalleteTransformation() {
  }

  public static Palette getPalette(Bitmap bitmap) {
    return CACHE.get(bitmap);
  }

  @Override public Bitmap transform(Bitmap source) {
    if (palette != null) {
      throw new IllegalStateException("Instances may only be used once.");
    }
    palette = new Palette.Builder(source).generate();
    CACHE.put(source, palette);
    return source;
  }

  @Override public String key() {
    return "pallete";
  }
}
