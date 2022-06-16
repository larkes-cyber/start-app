package com.example.StartApp.data.storage.database_for_goals

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.StartApp.data.storage.database_for_goals.dao.SomeDao
import com.example.StartApp.data.storage.database_for_goals.entity.EntitySomeData


@Database(entities = [EntitySomeData::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun someDao(): SomeDao

}