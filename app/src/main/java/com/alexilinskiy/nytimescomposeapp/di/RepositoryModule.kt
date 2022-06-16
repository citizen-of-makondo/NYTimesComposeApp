package com.alexilinskiy.nytimescomposeapp.di

import android.app.Application
import com.alexilinskiy.nytimescomposeapp.data.NewsRepository
import com.alexilinskiy.nytimescomposeapp.data.NewsRepositoryImpl
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager


@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun provideRepository(repositoryImpl: NewsRepositoryImpl): NewsRepository

}