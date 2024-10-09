package com.example.clean_architecture.presentation.model

import com.example.clean_architecture.data.model.User

data class UserModel(val id: String, val name: String, val email: String)


fun User.toUserModel(): UserModel {
    return UserModel(id = this.id, name = this.name, email = this.email)
}