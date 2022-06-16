package com.example.StartApp.data.storage

import com.example.StartApp.data.storage.models.SomeDataStorage

interface InterfaceService {
    suspend fun getFromDatabase():SomeDataStorage
    suspend fun insertToDatabase(props:SomeDataStorage)
}