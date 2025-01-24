package com.example.mavlianov_hw3_m6.ui.theme.Data.Api

import com.example.mavlianov_hw3_m6.ui.theme.Data.Dto.CharactersResultsResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
   suspend fun feetchAllCharacters(): Response<CharactersResultsResponse>
}