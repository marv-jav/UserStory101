package com.org.userstory101.ui.navigation

enum class NavigationRoute {
    HomeScreen,
    LockerScreen,
    RentScreen,
    AdvertScreen,
    AccountScreen,
    ProductScreen;

    companion object {
        fun fromRoute(route: String?): NavigationRoute = when (route) {
            HomeScreen.name -> HomeScreen
            LockerScreen.name -> LockerScreen
            RentScreen.name -> RentScreen
            AdvertScreen.name -> AdvertScreen
            AccountScreen.name -> AccountScreen
            ProductScreen.name -> ProductScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}