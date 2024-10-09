package com.example.clean_architecture.data.source.remote

import com.example.clean_architecture.data.model.User
import retrofit2.http.GET

interface UserApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}