package ru.mirea.azbukin.rickmorty;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class EpisodesClient {

    public static void main(String[] args) throws IOException {
        Retrofit client = new Retrofit
                .Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();

        EpisodeService episodeService = client.create(EpisodeService.class);
        Response<Result> response = episodeService.getEpisodes(1).execute();

        if (!response.isSuccessful() || response.body() == null) {
            System.out.println("Ошибка: " + response.code());
            return;
        }

        Result result = response.body();
        Episode maxCharactersEpisode = null;

        for (Episode episode : result.getResults()) {
            int charactersCount = episode.getCharacters().size();

            if (maxCharactersEpisode == null || charactersCount > maxCharactersEpisode.getCharacters().size()) {
                maxCharactersEpisode = episode;
            }
        }

        System.out.printf("Кол-во персонажей: %s\nНазвание: %s",
                maxCharactersEpisode.getCharacters().size(),
                maxCharactersEpisode.getName());

    }

}
