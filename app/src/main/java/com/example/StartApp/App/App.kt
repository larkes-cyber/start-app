package com.example.StartApp.App

import android.app.Application
import com.example.StartApp.di.AppComponent
import com.example.StartApp.di.AppModule
import com.example.StartApp.di.DaggerAppComponent

//that

class App:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }

}