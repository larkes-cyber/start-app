package com.example.StartApp.domain.repository

import com.example.StartApp.domain.model.SomeData

interface UserRepository {

    suspend fun pushSomeDataToServer(props: SomeData):String
    suspend fun getSomeDataFromServer():SomeData
    suspend fun insertToDataBase(props: SomeData)
    suspend fun getFromDatabase():SomeData
}