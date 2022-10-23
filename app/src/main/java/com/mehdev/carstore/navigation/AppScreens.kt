package com.mehdev.carstore.navigation

sealed class AppScreens(val route: String ) {
    object MainScreen: AppScreens(route = "main_screen")
    object FormScreen: AppScreens(route = "form_screen")
}
