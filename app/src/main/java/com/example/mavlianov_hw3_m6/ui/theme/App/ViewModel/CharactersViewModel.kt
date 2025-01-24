package com.example.mavlianov_hw3_m6.ui.theme.App.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mavlianov_hw3_m6.ui.theme.Data.Repository.CharacterRepository
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val characterRepository: CharacterRepository
): ViewModel() {


    fun fetchAllCharacters() {
        viewModelScope.launch {
            characterRepository.fetchAllCharacters()
            Log.e("CharactersViewModel", "fetchAllCharacters: $characterRepository")
        }
    }
}