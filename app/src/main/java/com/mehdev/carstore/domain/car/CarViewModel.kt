package com.mehdev.carstore.domain.car

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehdev.carstore.data.CarRepository
import kotlinx.coroutines.launch

class CarViewModel(private val carRepository: CarRepository) : ViewModel() {
    var state by mutableStateOf( CarState() )
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                cars = carRepository.getCars()
            )
        }
    }

    fun onChangeLicensePlate(value: String) {
        state = state.copy(
            licensePlate =  value
        )
    }

    fun onChangeModel(value: String) {
        state = state.copy(
            model =  value
        )
    }

    fun onChangeColor(value: String) {
        state = state.copy(
            color =  value
        )
    }

    fun saveCar() {
        viewModelScope.launch {
            carRepository.insertCar(Car(
                id = null,
                licensePlate = state.licensePlate.uppercase(),
                model = state.model,
                color = state.color
            ))

            state = state.copy(
                cars = carRepository.getCars(),
                licensePlate = "",
                model = "",
                color = ""
            )
        }
    }
}