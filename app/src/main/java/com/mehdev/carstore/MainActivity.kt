package com.mehdev.carstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.mehdev.carstore.data.CarDataBase
import com.mehdev.carstore.data.CarRepository
import com.mehdev.carstore.domain.car.CarViewModel
import com.mehdev.carstore.navigation.AppNavigation
import com.mehdev.carstore.ui.theme.CarStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      Initialize database
        val db = Room.databaseBuilder(this, CarDataBase::class.java, "car_store").build()
        val dao = db.dao
        val repository = CarRepository(dao)
        val mCarViewModel = CarViewModel(repository)
        setContent {
            CarStoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(mCarViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val db = Room.databaseBuilder(LocalContext.current, CarDataBase::class.java, "car_store").build()
    val dao = db.dao
    val repository = CarRepository(dao)
    val mCarViewModel = CarViewModel(repository)
    CarStoreTheme {
        AppNavigation(mCarViewModel)
    }
}