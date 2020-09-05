package com.example.roomdatabase.data.room

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllUser():LiveData<List<UserEntity>>

    @Insert
    fun addUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Query("DELETE FROM user_table")
    fun deleteAllUser()

}