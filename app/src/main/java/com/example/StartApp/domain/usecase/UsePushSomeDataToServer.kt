package com.example.StartApp.domain.usecase

import com.example.StartApp.domain.model.SomeData
import com.example.StartApp.domain.repository.UserRepository

class UsePushSomeDataToServer(private val userRepository: UserRepository) {

    suspend fun execute(props:SomeData):String{
        return userRepository.pushSomeDataToServer(props = props)
    }

}