package com.example.mavlianov_hw3_m6.ui.theme.App.Character

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CharacterDetailScreen(characterId: Int) {
    Text(text = "Character Details for Character #$characterId")
}
