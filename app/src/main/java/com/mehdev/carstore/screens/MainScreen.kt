@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.mehdev.carstore.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mehdev.carstore.components.CellCar
import com.mehdev.carstore.domain.car.CarViewModel
import com.mehdev.carstore.navigation.AppScreens
import com.mehdev.carstore.ui.theme.BlueDarkness
import com.mehdev.carstore.ui.theme.WhiteSmoke

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen (navController: NavController, mCarViewModel: CarViewModel) {
    Scaffold(
        floatingActionButton = {
            FABAddCar(navController)
        }
    ) {
        MainBody(mCarViewModel)
    }
}

@Composable
fun MainBody(mCarViewModel: CarViewModel) {
    LazyColumn {
        items(mCarViewModel.state.cars) { car ->
            CellCar(car = car)
        }
    }
}

@Composable
fun FABAddCar(navController: NavController) {
    FloatingActionButton(
        onClick = {
              navController.navigate(route = AppScreens.FormScreen.route)
        },
        containerColor = BlueDarkness
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            tint = WhiteSmoke
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultMainPreview() {
//    MainScreen(navController = rememberNavController())
//}