package com.org.userstory101.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.org.userstory101.ui.screens.AccountScreen
import com.org.userstory101.ui.screens.AdvertScreen
import com.org.userstory101.ui.screens.HomeScreen
import com.org.userstory101.ui.screens.LockerScreen
import com.org.userstory101.ui.screens.ProductScreen
import com.org.userstory101.ui.screens.RentScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoute.ProductScreen.name) {
        composable(NavigationRoute.LockerScreen.name) {
            LockerScreen(navController = navController)
        }
        composable(NavigationRoute.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(NavigationRoute.RentScreen.name) {
            RentScreen(navController = navController)
        }
        composable(NavigationRoute.AccountScreen.name) {
            AccountScreen(navController = navController)
        }
        composable(NavigationRoute.AdvertScreen.name) {
            AdvertScreen(navController = navController)
        }
        composable(NavigationRoute.ProductScreen.name) {
            ProductScreen(navController = navController)
        }
    }
}