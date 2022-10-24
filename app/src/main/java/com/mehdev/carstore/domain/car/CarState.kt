package com.mehdev.carstore.domain.car

data class CarState(
    val id: Int? = null,
    val licensePlate: String = "",
    val model: String = "",
    val color: String = "",
    val cars: List<Car> = emptyList()
)