package com.example.StartApp.domain.usecase

import com.example.StartApp.domain.model.SomeData
import com.example.StartApp.domain.repository.UserRepository

class UseGetFromDatabase(val userRepository: UserRepository) {

    suspend fun execute():SomeData{
        return userRepository.getFromDatabase()
    }

}