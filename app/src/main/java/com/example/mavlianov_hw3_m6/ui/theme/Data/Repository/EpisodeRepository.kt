package com.example.mavlianov_hw3_m6.ui.theme.Data.Repository

import com.example.mavlianov_hw3_m6.ui.theme.Data.Api.EpisodeApiService
import com.example.mavlianov_hw3_m6.ui.theme.Data.Dto.EpisodesResponse

class EpisodeRepository(
    private val apiService: EpisodeApiService
) {

    suspend fun fetchAllEpisodes(): List<EpisodesResponse>? {
        val response = apiService.fetchAllEpisodes()
        return if (response.isSuccessful) {
            response.body()?.episodesResponse
        } else {
            emptyList()
        }
    }
}
