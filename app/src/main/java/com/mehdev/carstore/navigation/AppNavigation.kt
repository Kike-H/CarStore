@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.mehdev.carstore.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.mehdev.carstore.domain.car.CarViewModel
import com.mehdev.carstore.screens.FormScreen
import com.mehdev.carstore.screens.MainScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(mCarViewModel: CarViewModel) {
    val tweenSpec = tween<IntOffset>(durationMillis = 200, easing = CubicBezierEasing(0.21f,0.28f,0.71f,0.79f))
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = AppScreens.MainScreen.route) {
        composable(route = AppScreens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            route = AppScreens.FormScreen.route,
            enterTransition = {
                slideInVertically(initialOffsetY = { 1000 }, animationSpec = tweenSpec)
            },
            exitTransition = {
                slideOutVertically(targetOffsetY = { 600 }, animationSpec = tweenSpec)
            }
        ) {
            FormScreen(navController, mCarViewModel)
        }
    }
}