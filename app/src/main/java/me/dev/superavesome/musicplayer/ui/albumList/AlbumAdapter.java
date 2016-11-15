package me.dev.superavesome.musicplayer.ui.albumList;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.model.Album;
import me.dev.superavesome.musicplayer.utils.PalleteTransformation;

class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumVH> {
    private final List<Album> albums;
    private final Context context;
    final Uri ART_CONTENT_URI = Uri.parse("content://media/external/audio/albumart");

    AlbumAdapter(List<Album> albums, Context context) {
      this.albums = albums;
      this.context = context;
    }

    @Override public AlbumVH onCreateViewHolder(ViewGroup parent, int viewType) {
      final LayoutInflater ll = LayoutInflater.from(parent.getContext());
      final View view = ll.inflate(R.layout.item_album, parent, false);
      return new AlbumVH(view);
    }

    @Override public void onBindViewHolder(final AlbumVH vh, int position) {
      Uri albumArtUri = ContentUris.withAppendedId(ART_CONTENT_URI, albums.get(position).getId());
      Picasso.with(context)
          .load(albumArtUri)
          .transform(PalleteTransformation.getInstance())
          .error(R.drawable.placeholder_with_padding)
          .into(vh.imgAlbum, new Callback.EmptyCallback() {
            @Override public void onSuccess() {
              super.onSuccess();
              final Bitmap bitmap = ((BitmapDrawable) vh.imgAlbum.getDrawable()).getBitmap(); // Ew!
              int color = PalleteTransformation.getPalette(bitmap).getDarkVibrantColor(Color.BLACK);
              vh.container.setBackgroundColor(color);
            }
          });
      vh.txtAlbum.setText(albums.get(position).getAlbumName());
      vh.txtArtist.setText(albums.get(position).getArtistName());
    }

    @Override public int getItemCount() {
      return albums.size();
    }
    public static class AlbumVH extends RecyclerView.ViewHolder {

        @Bind(R.id.img_album)
        ImageView imgAlbum;
        @Bind(R.id.txt_artist)
        TextView txtArtist;
        @Bind(R.id.txt_album) TextView txtAlbum;
        @Bind(R.id.container)
        LinearLayout container;

        public AlbumVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
  }