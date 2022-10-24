@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.mehdev.carstore.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mehdev.carstore.R
import com.mehdev.carstore.components.Input
import com.mehdev.carstore.domain.car.CarViewModel
import com.mehdev.carstore.ui.theme.BlueDarkness
import com.mehdev.carstore.ui.theme.WhiteSmoke
import io.ak1.drawbox.DrawBox
import io.ak1.drawbox.rememberDrawController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(navController: NavController, mCarViewModel: CarViewModel) {
    val focusManager = LocalFocusManager.current
    Scaffold(
        topBar = {
            TopAppBar(title = {})
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                tint = WhiteSmoke,
                modifier = Modifier
                    .padding(30.dp)
                    .clickable { navController.popBackStack() }
            )
        }
    ) {
        FormBody(mCarViewModel)
    }
}

@Composable
fun FormBody(mCarViewModel: CarViewModel) {
    val state = mCarViewModel.state
    val undoVisibility = remember { mutableStateOf(false) }
    val redoVisibility = remember { mutableStateOf(false) }
    val drawController = rememberDrawController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 110.dp, horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Input(
            label = "License Plate",
            value = state.licensePlate,
            callback = mCarViewModel::onChangeLicensePlate
        )
        Input(label = "Model", value = state.model, callback = mCarViewModel::onChangeModel)
        Input(label = "Color", value = state.color, callback = mCarViewModel::onChangeColor)
        DrawBox(
            drawController = drawController,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f, true)
                .paint(
                    painterResource(id = R.drawable.car),
                    contentScale = ContentScale.Inside
                ),
        ) { undoCount, redoCount ->
            undoVisibility.value = undoCount != 0
            redoVisibility.value = redoCount != 0
        }
        ElevatedButton(
            onClick = {
                mCarViewModel.saveCar()
            },
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp)
                .width(2000.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BlueDarkness)
        ) {
            Text(
                text = "SAVE CAR",
                fontSize = 22.sp,
                color = WhiteSmoke
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultFormPreview() {
//    FormScreen(navController = rememberNavController(), CarViewModel())
//}
