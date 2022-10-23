package com.mehdev.carstore.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CarEntity::class], version = 1)
abstract class CarDataBase: RoomDatabase() {
    abstract val dao: CarDao
}