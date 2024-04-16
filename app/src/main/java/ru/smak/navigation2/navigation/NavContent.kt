package ru.smak.navigation2.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.smak.navigation2.pages.Details
import ru.smak.navigation2.pages.Main
import ru.smak.navigation2.pages.Settings

@Composable
fun NavContent(
    navController: NavHostController,
    modifier: Modifier = Modifier,
){
    NavHost(
        navController = navController,
        startDestination = Page.MAIN.route,
        modifier = modifier,
    ){
        composable(Page.MAIN.route){
            Main(navController, Modifier.fillMaxSize())
        }
        composable(Page.DETAILS.route){
            Details(navController, Modifier.fillMaxSize())
        }
        composable(Page.SETTINGS.route){
            Settings(navController, Modifier.fillMaxSize())
        }
    }
}
