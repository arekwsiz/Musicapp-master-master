package com.example.stud.appmusic.api;

import com.example.stud.musicapp.api.SearchAlbums;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiClient {

    @GET( "trending.php" )
    Call<com.example.stud.Musicapp.api.TrendingList> getTrendingList(@Query( "country" ) String country, @Query ( "type" )
            String type, @Query ( "format" ) String format);

    @GET ( "track.php" )
    Call<com.example.stud.Musicapp.api.Tracks> getTrack(@Query ( "h" ) int trackId);
    @GET ( "searchalbum.php" )
    Call<SearchAlbums> searchAlbums(@Query ( "s" ) String artist);
}
