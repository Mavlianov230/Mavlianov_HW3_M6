package com.example.mavlianov_hw3_m6.ui.theme.Data.Dto

import com.google.gson.annotations.SerializedName

data class EpisodesResultsResponse(
    @SerializedName("results")
    val episodesResponse: List<EpisodesResponse>
)

data class EpisodesResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: String
)
