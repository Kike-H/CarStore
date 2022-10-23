package com.mehdev.carstore.domain.car

import com.mehdev.carstore.data.CarEntity

data class Car(
    val id: Int?,
    val licensePlate: String,
    val model: String,
    val color: String
)

fun Car.toEntity(): CarEntity {
    return CarEntity(id ?: 0, licensePlate, model, color)
}
