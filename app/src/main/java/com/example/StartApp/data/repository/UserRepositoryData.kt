package com.example.StartApp.data.repository

import com.example.StartApp.data.retrofit.model.RetrofitSomeData
import com.example.StartApp.domain.repository.UserRepository
import com.example.StartApp.data.retrofit.repository.RetrofitRepository
import com.example.StartApp.data.storage.Service
import com.example.StartApp.data.storage.get_id.GetIdForDataBase
import com.example.StartApp.data.storage.models.SomeDataStorage
import com.example.StartApp.domain.model.SomeData

class UserRepositoryData(
    private val service: Service,
    private val get_id: GetIdForDataBase,
    private val retrofitRepository: RetrofitRepository
    ): UserRepository {

    override suspend fun pushSomeDataToServer(props: SomeData): String {
        val resp = retrofitRepository.pushSomeDataToServer(props = RetrofitSomeData(
            some = props.some
        ))
        return "true"
    }

    override suspend fun getSomeDataFromServer(): SomeData {
        val data:RetrofitSomeData = retrofitRepository.getSomeData()
        return SomeData(some = data.some)
    }


    override suspend fun insertToDataBase(props: SomeData) {
        service.insertToDatabase(props = SomeDataStorage(
            some = props.some
        ))
    }

    override suspend fun getFromDatabase(): SomeData {
        val data = service.getFromDatabase()
        return SomeData(
            id = data.id,
            some = data.some
        )
    }


}