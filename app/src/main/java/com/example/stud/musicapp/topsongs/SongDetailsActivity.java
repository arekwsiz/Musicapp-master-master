package com.example.stud.appmusic.topsongs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.stud.appmusic.R;
import com.example.stud.appmusic.api.ApiService;
import com.example.stud.appmusic.api.Tracks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongDetailsActivity extends AppCompatActivity {

    public static final String TRACK = "track";
    public static final String ARTIST = "artist";
    public static final String TRACK_ID = "track_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        String track = intent.getStringExtra(TRACK);
        String artist = intent.getStringExtra(ARTIST);
        int trackId = intent.getIntExtra(TRACK_ID, 0);

        Toast.makeText(this, track, Toast.LENGTH_SHORT).show();

        getSupportActionBar().setTitle(track);
        getSupportActionBar().setSubtitle(artist);


        ApiService.getService().getTrack(trackId).enqueue(new Callback<Tracks>() {
            @Override
            public void onResponse(@NonNull Call<Tracks> call, @NonNull Response<Tracks>
                    response) {
                Toast.makeText(
                        SongDetailsActivity.this,
                        "Pobrano dane", Toast.LENGTH_SHORT
                ).show();
            }

            @Override
            public void onFailure(@NonNull Call<Tracks> call, @NonNull Throwable t) {
                Toast.makeText(
                        SongDetailsActivity.this,
                        "Błąd pobierania danych: " + t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
