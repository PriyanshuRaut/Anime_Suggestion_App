package com.masters.anisuge;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masters.anisuge.Retrofit.RetrofitClient;
import com.masters.anisuge.adapter.AnimeAdapter;
import com.masters.anisuge.api.JikanApiService;
import com.masters.anisuge.model.AnimeModel;
import com.masters.anisuge.model.AnimeModel.AnimeData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimeAdapter animeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.anime_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchAnimeData();
    }

    private void fetchAnimeData() {
        JikanApiService apiService = RetrofitClient.getRetrofitInstance().create(JikanApiService.class);

        apiService.getCurrentSeasonAnime().enqueue(new Callback<AnimeModel>() {
            @Override
            public void onResponse(Call<AnimeModel> call, Response<AnimeModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<AnimeData> animeList = response.body().data;
                    animeAdapter = new AnimeAdapter(MainActivity.this, animeList);
                    recyclerView.setAdapter(animeAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AnimeModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
