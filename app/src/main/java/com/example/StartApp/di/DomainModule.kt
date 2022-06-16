package com.example.StartApp.di

import com.example.StartApp.domain.repository.UserRepository
import com.example.StartApp.domain.usecase.UseGetFromDatabase
import com.example.StartApp.domain.usecase.UseGetSomeDataFromServer
import com.example.StartApp.domain.usecase.UseInsertToDatabase
import com.example.StartApp.domain.usecase.UsePushSomeDataToServer
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideUseGetFromDatabase(userRepository: UserRepository):UseGetFromDatabase{
        return UseGetFromDatabase(
            userRepository = userRepository
        )
    }
    @Provides
    fun provideUseGetSomeDataFromServer(userRepository: UserRepository):UseGetSomeDataFromServer{
        return UseGetSomeDataFromServer(
            userRepository = userRepository
        )
    }
    @Provides
    fun provideUseInsertToDatabase(userRepository: UserRepository):UseInsertToDatabase{
        return UseInsertToDatabase(
            userRepository = userRepository
        )
    }
    @Provides
    fun provideUsePushSomeDataToServer(userRepository: UserRepository):UsePushSomeDataToServer{
        return UsePushSomeDataToServer(
            userRepository = userRepository
        )
    }
}