package me.dev.superavesome.musicplayer.ui.artistList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.model.Artist;

class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.ArtistVH> {
    private final List<Artist> artists;
    private final Context context;

    ArtistListAdapter(List<Artist> artists, Context context) {
        this.artists = artists;
        this.context = context;
    }

    @Override
    public ArtistVH onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater ll = LayoutInflater.from(parent.getContext());
        final View view = ll.inflate(R.layout.item_artist, parent, false);
        return new ArtistVH(view);
    }

    @Override
    public void onBindViewHolder(final ArtistVH vh, int position) {
        final Artist artist = artists.get(position);

        vh.txtArtistName.setText(artist.getName());
        //todo use String builder
        String artistInfo = String.valueOf(artist.getNumAlbums()) +
                ((artist.getNumAlbums() > 1) ? " Albums  " : " Album  ") +
                artist.getNumTracks() +
                (artist.getNumTracks() > 1 ? " Tracks" : " Track");
        vh.txtArtistInfo.setText(artistInfo);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    static class ArtistVH extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_artist_name)
        TextView txtArtistName;
        @BindView(R.id.txt_artist_info)
        TextView txtArtistInfo;

        ArtistVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}