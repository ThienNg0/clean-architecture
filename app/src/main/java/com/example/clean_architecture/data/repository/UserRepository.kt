package com.example.clean_architecture.data.repository

import com.example.clean_architecture.data.model.User

interface UserRepository {
    suspend fun getUser():List<User>

}