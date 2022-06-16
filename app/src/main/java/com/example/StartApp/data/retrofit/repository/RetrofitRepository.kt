package com.example.StartApp.data.retrofit.repository

import com.example.StartApp.data.retrofit.model.RetrofitSomeData
import com.example.StartApp.data.retrofit.model.RetrofitSomeDataResponse
import com.example.StartApp.data.retrofit.api.RetrofitInstance
import retrofit2.Response


class RetrofitRepository: RetrofitInterface {
    override suspend fun pushSomeDataToServer(props: RetrofitSomeData): Response<RetrofitSomeDataResponse> {
        return RetrofitInstance().api.pushSomeData(props)
    }

    override suspend fun getSomeData(): RetrofitSomeData {
        return RetrofitInstance().api.getSomeData()
    }


}