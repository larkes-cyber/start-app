package com.example.StartApp.domain.usecase

import com.example.StartApp.domain.model.SomeData
import com.example.StartApp.domain.repository.UserRepository

class UseInsertToDatabase(val userRepository: UserRepository) {

    suspend fun execute(props:SomeData){
        userRepository.insertToDataBase(props = props)
    }

}