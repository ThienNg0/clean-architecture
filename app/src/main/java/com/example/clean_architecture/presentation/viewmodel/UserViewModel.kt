package com.example.clean_architecture.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture.data.model.User
import com.example.clean_architecture.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    // Sử dụng MutableLiveData để giữ danh sách người dùng
    private val _users = MutableLiveData<List<User>>()
    // Public LiveData mà các component khác có thể quan sát
    val users: LiveData<List<User>> get() = _users

    // Hàm gọi để fetch danh sách người dùng từ UseCase
    fun fetchUsers() {
        viewModelScope.launch {
            val userList = getUsersUseCase() // Gọi use case để lấy danh sách người dùng
            _users.postValue(userList)       // Sử dụng postValue vì đang không trên UI thread
        }
    }
    fun searchUsers(query: String) {
        viewModelScope.launch {
            val filteredList = getUsersUseCase().filter {
                it.name.contains(query, ignoreCase = true)
            }
            _users.postValue(filteredList)
        }
    }
}