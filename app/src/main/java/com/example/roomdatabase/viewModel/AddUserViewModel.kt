package com.example.roomdatabase.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roomdatabase.data.room.UserEntity
import com.example.roomdatabase.repository.UserRepository

class AddUserViewModel (application: Application): AndroidViewModel(application) {

    private  var userRepository : UserRepository = UserRepository.getInstance(application)
    private  var userList : LiveData<List<UserEntity>> = MutableLiveData()
    private  var users : MutableLiveData<UserEntity> = MutableLiveData()

    fun addUser(userEntity: UserEntity) {
        userRepository.addUser(userEntity);
    }
}