package com.example.StartApp.data.retrofit.repository

import com.example.StartApp.data.retrofit.model.RetrofitSomeData
import com.example.StartApp.data.retrofit.model.RetrofitSomeDataResponse
import retrofit2.Response


interface RetrofitInterface {

    suspend fun pushSomeDataToServer(props:RetrofitSomeData):Response<RetrofitSomeDataResponse>
    suspend fun getSomeData():RetrofitSomeData

}