package com.example.mavlianov_hw3_m6.ui.theme.tools.Main

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mavlianov_hw3_m6.ui.theme.tools.App.AppBottomBar
import com.example.mavlianov_hw3_m6.ui.theme.tools.App.AppTopBar
import com.example.mavlianov_hw3_m6.ui.theme.tools.Character.CharacterDetailScreen
import com.example.mavlianov_hw3_m6.ui.theme.tools.Character.CharactersScreen
import com.example.mavlianov_hw3_m6.ui.theme.tools.Episode.EpisodeDetailScreen
import com.example.mavlianov_hw3_m6.ui.theme.tools.Episode.EpisodesScreen
import com.example.mavlianov_hw3_m6.ui.theme.tools.Location.LocationDetailScreen
import com.example.mavlianov_hw3_m6.ui.theme.tools.Location.LocationsScreen

@Composable
fun MainNavScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { AppTopBar(navController) },
        bottomBar = { AppBottomBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "characters"
            ) {
                composableWithTransitions("characters") { CharactersScreen(navController) }
                composableWithTransitions("locations") { LocationsScreen(navController) }
                composableWithTransitions("episodes") { EpisodesScreen(navController) }
                composableWithTransitions("character_detail/{characterId}") { backStackEntry ->
                    val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
                    if (characterId != null) {
                        CharacterDetailScreen(characterId)
                    }
                }
                composableWithTransitions("location_detail/{locationId}") { backStackEntry ->
                    val locationId = backStackEntry.arguments?.getString("locationId")?.toIntOrNull()
                    if (locationId != null) {
                        LocationDetailScreen(locationId)
                    }
                }
                composableWithTransitions("episode_detail/{episodeId}") { backStackEntry ->
                    val episodeId = backStackEntry.arguments?.getString("episodeId")?.toIntOrNull()
                    if (episodeId != null) {
                        EpisodeDetailScreen(episodeId)
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.composableWithTransitions(
    route: String,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(route, content = content)
}
