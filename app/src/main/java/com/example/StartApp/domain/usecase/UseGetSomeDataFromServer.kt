package com.example.StartApp.domain.usecase

import com.example.StartApp.domain.model.SomeData
import com.example.StartApp.domain.repository.UserRepository

class UseGetSomeDataFromServer(private val userRepository: UserRepository) {

    suspend fun execute():SomeData{
        return userRepository.getSomeDataFromServer()
    }

}