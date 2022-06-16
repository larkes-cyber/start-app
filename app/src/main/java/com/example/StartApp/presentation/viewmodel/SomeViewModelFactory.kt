package com.example.StartApp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.StartApp.domain.usecase.UseGetFromDatabase
import com.example.StartApp.domain.usecase.UseGetSomeDataFromServer
import com.example.StartApp.domain.usecase.UseInsertToDatabase
import com.example.StartApp.domain.usecase.UsePushSomeDataToServer

class SomeViewModelFactory (

    val useGetSomeDataFromServer: UseGetSomeDataFromServer,
    val useGetFromDatabase: UseGetFromDatabase,
    val useInsertToDatabase: UseInsertToDatabase,
    val usePushSomeDataToServer: UsePushSomeDataToServer

): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SomeViewModel(
            useGetSomeDataFromServer = useGetSomeDataFromServer,
            useGetFromDatabase = useGetFromDatabase,
            useInsertToDatabase = useInsertToDatabase,
            usePushSomeDataToServer = usePushSomeDataToServer
        ) as T
    }
}