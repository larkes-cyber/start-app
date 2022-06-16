package com.example.StartApp.data.storage.get_id

import android.content.Context

class GetIdForDataBase(
    private val context: Context
) {

    private val sharedPreferences = context.getSharedPreferences("ID", Context.MODE_PRIVATE)

    fun get_goal_id():Int {
        if(sharedPreferences.getInt("ID", -1) == -1){

            sharedPreferences.edit().putInt("ID", 0).apply()

            return 0
        }
        else{

            val id = sharedPreferences.getInt("ID", -1) + 1

            sharedPreferences.edit().putInt("ID", id).apply()

            return id

        }

    }




}