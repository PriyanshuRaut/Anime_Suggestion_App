package com.masters.anisuge.api;

import com.masters.anisuge.model.AnimeModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JikanApiService {

    @GET("seasons/now?sfw")
    Call<AnimeModel> getCurrentSeasonAnime();

}
