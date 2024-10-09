package com.example.clean_architecture.data.repository

import com.example.clean_architecture.data.model.User
import com.example.clean_architecture.data.source.remote.UserApiService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApiService : UserApiService
): UserRepository {

    override suspend fun getUser(): List<User> {
        return userApiService.getUsers()
    }

}