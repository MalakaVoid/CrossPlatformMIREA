package ru.mirea.azbukin.rickmorty;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EpisodeService {

    @GET("episode")
    Call<Result> getEpisodes(@Query("page") int page);

}
