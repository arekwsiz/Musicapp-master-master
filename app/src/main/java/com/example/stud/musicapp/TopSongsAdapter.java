package com.example.stud.musicapp.topsongs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stud.musicapp.R;
import com.example.stud.musicapp.api.TrendingSingle;

import java.util.List;

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsAdapter.TopSongsViewHolders> {

    private List<TrendingSingle> trending;

    public TopSongsAdapter(List<TrendingSingle> trending) {
        this.trending = trending;
    }

    @Override
    public TopSongsViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_top_songs, parent, false);

        return new TopSongsViewHolders(view);
    }

    @Override
    public void onBindViewHolder(TopSongsViewHolders holder, int position) {
        TrendingSingle trendingSingle = trending.get(position);

        holder.tvPlace.setText(String.valueOf(trendingSingle.intChartPlace));
        holder.tvTrack.setText(trendingSingle.strTrack);
        holder.tvArtist.setText(trendingSingle.strArtist);
        holder.tvAlbum.setText(trendingSingle.strAlbum);
    }

    @Override
    public int getItemCount() {
        return this.trending != null ? this.trending.size() : 0;
    }

    public class TopSongsViewHolders extends RecyclerView.ViewHolder {

        TextView tvPlace;
        TextView tvTrack;
        TextView tvArtist;
        TextView tvAlbum;

        public TopSongsViewHolders(View itemView) {
            super(itemView);

            tvPlace = itemView.findViewById(R.id.tvPlace);
            tvTrack = itemView.findViewById(R.id.tvTrack);
            tvArtist = itemView.findViewById(R.id.tvArtist);
            tvAlbum = itemView.findViewById(R.id.tvAlbum);
        }
    }

}