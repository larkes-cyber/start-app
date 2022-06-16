package com.example.StartApp.data.storage.database_for_goals.dao

import androidx.room.*
import com.example.StartApp.data.storage.database_for_goals.entity.EntitySomeData

@Dao
interface SomeDao {

    @Insert
    suspend fun addSome(entitySomeData: EntitySomeData)

    @Query("SELECT * FROM EntitySomeData")
    suspend fun getAllSome():MutableList<EntitySomeData>

    @Delete
    suspend fun removeSome(entitySomeData: EntitySomeData)

    @Update
    suspend fun updateSome(entitySomeData: EntitySomeData)

}