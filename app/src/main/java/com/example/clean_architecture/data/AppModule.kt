package com.example.clean_architecture.data

import com.example.clean_architecture.data.repository.UserRepository
import com.example.clean_architecture.data.repository.UserRepositoryImpl
import com.example.clean_architecture.data.source.remote.RetrofitInstance
import com.example.clean_architecture.data.source.remote.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Phương thức cung cấp UserApiService
    @Provides
    @Singleton
    fun provideUserApiService(): UserApiService {
        return RetrofitInstance.api
    }

    // Phương thức cung cấp UserRepository
    @Provides
    @Singleton
    fun provideUserRepository(apiService: UserApiService): UserRepository {
        return UserRepositoryImpl(apiService) // Trả về instance của UserRepositoryImpl
    }
}
