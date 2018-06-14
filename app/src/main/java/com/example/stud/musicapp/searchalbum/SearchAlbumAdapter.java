package com.example.stud.musicapp.searchalbum;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stud.musicapp.api.SearchAlbum;

import java.util.List;

import static sun.text.bidi.BidiBase.R;

/**
 * Created by W57448 on 2018-06-14.
 */

public class SearchAlbumAdapter extends RecyclerView.Adapter<SearchAlbumAdapter.SearchAlbumViewHolder> {

        private List<SearchAlbum> albums;

        public SearchAlbumAdapter(List<SearchAlbum> albums) {
            this.albums = albums;
        }

        @Override
        public SearchAlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_search_album, parent, false);

            return new SearchAlbumViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SearchAlbumViewHolder holder, int position) {
            SearchAlbum album = albums.get(position);

            holder.tvAlbum.setText(album.strAlbum);
            holder.tvYearReleased.setText(String.valueOf(album.intYearReleased));
            holder.tvSales.setText(String.valueOf(album.intSales));
            holder.tvScore.setText(String.valueOf(album.intScore));
        }

        @Override
        public int getItemCount() {
            return albums == null ? 0 : albums.size();
        }

        public class SearchAlbumViewHolder extends RecyclerView.ViewHolder {

            TextView tvAlbum;
            TextView tvYearReleased;
            TextView tvSales;
            TextView tvScore;

            public SearchAlbumViewHolder(View itemView) {
                super(itemView);

                tvAlbum = itemView.findViewById(R.id.tvAlbum);
                tvYearReleased = itemView.findViewById(R.id.tvYearReleased);
                tvSales = itemView.findViewById(R.id.tvSales);
                tvScore = itemView.findViewById(R.id.tvScore);
            }
        }

    }
}
