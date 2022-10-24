package com.mehdev.carstore.data

import com.mehdev.carstore.domain.car.Car
import com.mehdev.carstore.domain.car.toEntity

class CarRepository(private val carDao: CarDao) {
    suspend fun getCars(): List<Car> {
        return carDao.getCars().map { it.toModel() }
    }

    suspend fun insertCar(car: Car) {
        carDao.insertCar(car.toEntity())
    }

    suspend fun deleteCar(car: Car){
        carDao.deleteCar(car.toEntity())
    }
}