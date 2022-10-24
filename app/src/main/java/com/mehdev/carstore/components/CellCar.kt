package com.mehdev.carstore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mehdev.carstore.domain.car.Car
import com.mehdev.carstore.navigation.AppScreens
import com.mehdev.carstore.ui.theme.DangerRed
import com.mehdev.carstore.ui.theme.WhiteSmoke

@Composable
fun CellCar(car: Car, navController: NavController ,callback: (car: Car) -> Unit, calllbackTwo:(car: Car) -> Unit) {
    Column {
        Row(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(DangerRed)
                    .clickable { callback(car) },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = WhiteSmoke,
                    modifier = Modifier
                        .size(45.dp)
                        .padding(5.dp)
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
            Texts(car = car, navController, calllbackTwo)

        }
        Divider()
    }
}

@Composable
fun Texts(car: Car, navController: NavController, callback: (car: Car) -> Unit) {
    Row(modifier = Modifier
        .absolutePadding(right = 30.dp)
        .clickable {
            navController.navigate(AppScreens.FormScreen.route)
            callback(car)
        }
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(
                text = "Plate: ${car.licensePlate}",
                fontSize = 17.sp,
                maxLines = 2,
                modifier = Modifier.padding(vertical = 2.dp)
            )
            Text(
                text = "Model: ${car.model}",
                fontSize = 15.sp,
                modifier = Modifier.padding(vertical = 2.dp)
            )
            Text(
                text = "Color: ${car.color}",
                fontSize = 15.sp,
                modifier = Modifier.padding(vertical = 2.dp)
            )
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun DefaultCellCarPreview() {
//    fun callback (car: Car) {}
//    CellCar(Car(id = null, licensePlate = "XPPA24", model = "Honda", color = "Red"), ::callback)
//}