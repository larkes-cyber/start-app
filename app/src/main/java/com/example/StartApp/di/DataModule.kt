package com.example.StartApp.di

import android.content.Context
import androidx.room.Room
import com.example.StartApp.data.repository.UserRepositoryData
import com.example.StartApp.data.retrofit.repository.RetrofitRepository
import com.example.StartApp.data.storage.Service
import com.example.StartApp.data.storage.database_for_goals.AppDatabase
import com.example.StartApp.data.storage.database_for_goals.dao.SomeDao
import com.example.StartApp.data.storage.database_for_goals.repository.DataBaseRepository
import com.example.StartApp.data.storage.get_id.GetIdForDataBase
import com.example.StartApp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,"goals_database"
        ).build()
    }


    @Provides
    fun provideSomeDao(database: AppDatabase): SomeDao {
        return database.someDao()
    }

    @Provides
    fun provideRetrofitRepository(): RetrofitRepository {
        return RetrofitRepository()
    }


    @Provides
    fun provideDataBaseRepository(context: Context): DataBaseRepository {
        return DataBaseRepository(context)
    }


    @Provides
    fun provideService(
        context: Context,
        dataBaseRepository: DataBaseRepository
    ): Service {
        return Service(context,dataBaseRepository)
    }

    @Provides
    fun provideGetId(context: Context): GetIdForDataBase {
        return GetIdForDataBase(context)
    }

    @Provides
    fun provideUserRepository(
        service:Service,
        get_id:GetIdForDataBase,
        retrofitRepository: RetrofitRepository
    ): UserRepository {

        return UserRepositoryData(service, get_id, retrofitRepository)

    }
}