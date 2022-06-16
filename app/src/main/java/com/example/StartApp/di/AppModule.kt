package com.example.StartApp.di

import android.content.Context
import com.example.StartApp.domain.usecase.UseGetFromDatabase
import com.example.StartApp.domain.usecase.UseGetSomeDataFromServer
import com.example.StartApp.domain.usecase.UseInsertToDatabase
import com.example.StartApp.domain.usecase.UsePushSomeDataToServer
import com.example.StartApp.presentation.viewmodel.SomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
   fun provideContext():Context{
        return context
    }

    @Provides
    fun provideSomeViewModelFactory(
         useGetFromDatabase: UseGetFromDatabase,
         useGetSomeDataFromServer: UseGetSomeDataFromServer,
         useInsertToDatabase: UseInsertToDatabase,
         usePushSomeDataToServer: UsePushSomeDataToServer
    ):SomeViewModelFactory{
        return SomeViewModelFactory(
            usePushSomeDataToServer = usePushSomeDataToServer,
            useInsertToDatabase = useInsertToDatabase,
            useGetFromDatabase = useGetFromDatabase,
            useGetSomeDataFromServer = useGetSomeDataFromServer
        )
    }



}