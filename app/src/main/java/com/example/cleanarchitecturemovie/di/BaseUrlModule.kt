package com.example.cleanarchitecturemovie.di

import com.example.cleanarchitecturemovie.BuildConfig
import com.example.di.qualifier.AppBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BaseUrlModule{
    @Provides
    @AppBaseUrl
    fun provideBaseUrl():String = BuildConfig.base_url
}