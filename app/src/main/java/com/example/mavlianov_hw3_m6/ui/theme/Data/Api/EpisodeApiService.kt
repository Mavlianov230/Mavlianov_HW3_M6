package com.example.mavlianov_hw3_m6.ui.theme.Data.Api

import com.example.mavlianov_hw3_m6.ui.theme.Data.Dto.EpisodesResultsResponse
import retrofit2.Response
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun fetchAllEpisodes(): Response<EpisodesResultsResponse>
}
