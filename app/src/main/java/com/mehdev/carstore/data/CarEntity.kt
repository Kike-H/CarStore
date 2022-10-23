package com.mehdev.carstore.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mehdev.carstore.domain.car.Car

@Entity(tableName = "car_table")
data class CarEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val licensePlate: String,
    val model: String,
    val color: String
)

fun CarEntity.toModel(): Car {
    return Car(id, licensePlate, model, color)
}