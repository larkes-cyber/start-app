package com.example.StartApp.data.retrofit.api

import com.example.StartApp.data.retrofit.untils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: RetrofitApi by lazy {
        retrofit.create(RetrofitApi::class.java)
    }

}