package com.example.sw_api.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sw_api.screens.CharactersScreen
import com.example.sw_api.screens.DetailsScreen


@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CharacterScreenRoute
    ){
        composable<CharacterScreenRoute>{
            CharactersScreen( onCharacterClick = { url: String -> navController.navigate(
                DetailsScreenRoute(url)) } )
        }
        composable<DetailsScreenRoute> { backStackEntry ->
            val details: DetailsScreenRoute = backStackEntry.toRoute()
            DetailsScreen(details.url) {
                if (navController.previousBackStackEntry != null) { navController.popBackStack() }
            }
        }
    }

}