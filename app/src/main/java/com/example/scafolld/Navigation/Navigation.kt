package com.example.scafolld.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.StateFactoryMarker
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Navigation.Main) {
        navigation<Navigation.Main>(startDestination = Routes.Home) {
            composable<Routes.Home> {
                HomeScreen(navController = navController)
            }
            composable<Routes.WishList> {
                WishListScreen(navController = navController)
            }

        }
    }
}
