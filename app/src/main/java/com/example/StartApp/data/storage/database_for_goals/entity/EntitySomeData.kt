package com.example.StartApp.data.storage.database_for_goals.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EntitySomeData(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    val some:String

    )
