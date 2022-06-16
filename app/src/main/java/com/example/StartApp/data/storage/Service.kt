package com.example.StartApp.data.storage

import android.content.Context
import com.example.StartApp.data.storage.database_for_goals.repository.DataBaseRepository
import com.example.StartApp.data.storage.models.SomeDataStorage

class Service(
    context:Context,
    private val dataBaseRepository: DataBaseRepository
): InterfaceService {

    private val context = context
    override suspend fun getFromDatabase(): SomeDataStorage {
      return dataBaseRepository.getFromDatabase()
    }

    override suspend fun insertToDatabase(props: SomeDataStorage) {
        dataBaseRepository.insertToDatabase(props = props)
    }

}