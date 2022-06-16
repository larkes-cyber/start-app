package com.example.StartApp.di

import com.example.StartApp.data.storage.database_for_goals.repository.DataBaseRepository
import com.example.StartApp.presentation.fragment.SomeFragment
import dagger.Component

@Component(modules = [AppModule::class,DomainModule::class, DataModule::class])
 interface AppComponent {
    fun injectDataBaseRepository(dataBaseRepository: DataBaseRepository)
    fun injectSomeFragment(someFragment: SomeFragment)
}