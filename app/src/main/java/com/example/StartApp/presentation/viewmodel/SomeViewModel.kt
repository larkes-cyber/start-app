package com.example.StartApp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.StartApp.domain.model.SomeData
import com.example.StartApp.domain.usecase.UseGetFromDatabase
import com.example.StartApp.domain.usecase.UseGetSomeDataFromServer
import com.example.StartApp.domain.usecase.UseInsertToDatabase
import com.example.StartApp.domain.usecase.UsePushSomeDataToServer

class SomeViewModel (
    val useGetFromDatabase:UseGetFromDatabase,
    val useGetSomeDataFromServer: UseGetSomeDataFromServer,
    val useInsertToDatabase: UseInsertToDatabase,
    val usePushSomeDataToServer: UsePushSomeDataToServer
): ViewModel() {

    private var lifeResultDatabase = MutableLiveData<SomeData>()
     val lifeResultDatabaseConst: LiveData<SomeData> = lifeResultDatabase

    private var lifeResultServer = MutableLiveData<SomeData>()
    val lifeResultServerConst: LiveData<SomeData> = lifeResultDatabase

    suspend fun getFromDatabase(){
        lifeResultDatabase.value = useGetFromDatabase.execute()
    }

    suspend fun getFromServer(){
        lifeResultServer.value = useGetSomeDataFromServer.execute()
    }
    suspend fun insertToDatabase(props:SomeData){
        useInsertToDatabase.execute(props = props)
    }
    suspend fun pushSomeDataToServer(props: SomeData){
        usePushSomeDataToServer.execute(props = props)
    }

}