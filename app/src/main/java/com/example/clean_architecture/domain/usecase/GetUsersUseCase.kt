package com.example.clean_architecture.domain.usecase

import com.example.clean_architecture.data.model.User
import com.example.clean_architecture.data.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository)
{
    suspend operator fun invoke(): List<User>
    {
        return userRepository.getUser()
    }

}