package com.example.roomdatabase.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.roomdatabase.data.room.UserDao
import com.example.roomdatabase.data.room.UserDatabase
import com.example.roomdatabase.data.room.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserRepository(applicationContext: Application) {

    private var userDao: UserDao? = null
    private var allUser: LiveData<List<UserEntity>>? = null

    companion object {
        @Volatile private var INSTANCE  : UserRepository? = null

        fun getInstance(applicationContext : Application) : UserRepository {
            return INSTANCE ?: UserRepository(applicationContext)
        }
    }

    init {
        val database : UserDatabase? = UserDatabase.getInstance(applicationContext)
        userDao = database!!.userDao()
        allUser = userDao!!.getAllUser()
    }

     fun addUser(userEntity: UserEntity){
         CoroutineScope(Dispatchers.IO).launch {
             userDao!!.addUser(userEntity)
         }
    }

     fun updateUser(userEntity: UserEntity){
      CoroutineScope(Dispatchers.IO).launch {
          userDao!!.updateUser(userEntity)
      }
    }


    fun deleteAllUser(){
        CoroutineScope(Dispatchers.IO).launch {
            userDao!!.deleteAllUser()
        }

    }

    fun getAllUser():LiveData<List<UserEntity>>{
        return allUser!!
    }
}