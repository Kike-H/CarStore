package com.mehdev.carstore.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mehdev.carstore.domain.car.Car
import com.mehdev.carstore.ui.theme.BlueDarkness

@Composable
fun CellCar(car: Car) {
    Row(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text("🚗", fontSize = 80.sp, modifier = Modifier.padding(horizontal = 5.dp))
        Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 26.dp)) {
            Text(
                text = "License Plate: ${car.licensePlate}",
                fontSize = 18.sp,
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

@Preview(showSystemUi = true)
@Composable
fun DefaultCellCarPreview() {
    CellCar(Car(id = null, licensePlate = "XPPA24", model = "Honda", color = "Red"))
}