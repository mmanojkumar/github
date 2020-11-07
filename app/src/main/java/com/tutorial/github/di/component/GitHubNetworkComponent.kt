package com.tutorial.github.di.component

import android.content.Context
import com.tutorial.github.data.network.GitHubRestClient
import com.tutorial.github.di.module.ContextModule
import com.tutorial.github.di.module.GitHubNetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [GitHubNetworkModule::class, ContextModule::class])
interface GitHubNetworkComponent{
    fun retrofit(): Retrofit
    fun gitHubRestClient(): GitHubRestClient
    fun context() :Context
}