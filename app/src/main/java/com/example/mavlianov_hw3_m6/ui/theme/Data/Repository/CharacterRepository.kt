package com.example.mavlianov_hw3_m6.ui.theme.Data.Repository

import com.example.mavlianov_hw3_m6.ui.theme.Data.Api.CharacterApiService
import com.example.mavlianov_hw3_m6.ui.theme.Data.Dto.CharactersResponse

class CharacterRepository(
    private val apiService: CharacterApiService
) {

    suspend fun fetchAllCharacters():List<CharactersResponse>?{
        val response = apiService.feetchAllCharacters()
        return if (response.isSuccessful) {
            response.body()?.charactersResponse
        }else{
           emptyList()
        }
    }
}