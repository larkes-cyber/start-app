package com.example.StartApp.data.retrofit.api

import com.example.StartApp.data.retrofit.model.RetrofitSomeData
import com.example.StartApp.data.retrofit.model.RetrofitSomeDataResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface RetrofitApi {

    @GET("posts/1")
    suspend fun getSomeData(): RetrofitSomeData

    @Headers("Content-Type: application/json")
    @POST("/v0.1/my_wey/reg")
    suspend fun pushSomeData(
       @Body retrofitGoalData: RetrofitSomeData
    ): Response<RetrofitSomeDataResponse>

}