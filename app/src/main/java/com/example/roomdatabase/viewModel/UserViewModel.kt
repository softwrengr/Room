package com.example.roomdatabase.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.room.UserEntity
import com.example.roomdatabase.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

    private  var userRepository : UserRepository = UserRepository.getInstance(application)
    private  var userList : LiveData<List<UserEntity>> = MutableLiveData()

     fun addUser(userEntity: UserEntity) {
        userRepository.addUser(userEntity);
    }

     fun updateUser(userEntity: UserEntity) {
        userRepository.updateUser(userEntity);
    }

     fun deleteUser() {
        userRepository.deleteAllUser()
    }

     fun getAllUser(): LiveData<List<UserEntity>> {
        return userRepository.getAllUser()
    }

}