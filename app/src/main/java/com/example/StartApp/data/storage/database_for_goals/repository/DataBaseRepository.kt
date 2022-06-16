package com.example.StartApp.data.storage.database_for_goals.repository

import android.content.Context
import com.example.StartApp.App.App

import com.example.StartApp.data.storage.InterfaceService
import com.example.StartApp.data.storage.database_for_goals.dao.SomeDao
import com.example.StartApp.data.storage.database_for_goals.entity.EntitySomeData
import com.example.StartApp.data.storage.models.SomeDataStorage
import javax.inject.Inject


class DataBaseRepository(private val context: Context): InterfaceService {
    @Inject
    lateinit var someDao: SomeDao

    init{
        (context as App).appComponent.injectDataBaseRepository(this)
    }

    override suspend fun getFromDatabase(): SomeDataStorage {
        val data = someDao.getAllSome()[0]
        return SomeDataStorage(
            some = data.some
        )
    }

    override suspend fun insertToDatabase(props: SomeDataStorage) {
        someDao.addSome(entitySomeData = EntitySomeData(
            some = props.some
        ))
    }

}