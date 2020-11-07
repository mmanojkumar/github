package com.tutorial.github.di.module

import android.content.Context
import com.tutorial.github.commits.latest.data.network.GitHubRestClient
import com.tutorial.github.commits.latest.data.network.interceptor.InternetConnectionInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.tutorial.github.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class GitHubNetworkModule{

    @Provides
    fun retrofit(okHttpClient: OkHttpClient, githubUrl:String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(githubUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun gitHubRestClient(retrofit: Retrofit): GitHubRestClient {
        return GitHubRestClient(
            retrofit
        )
    }

    @Provides
    fun okHttpClient(context: Context): OkHttpClient {
        val builder = OkHttpClient.Builder()

        if(BuildConfig.DEBUG){
           builder.addInterceptor(HttpLoggingInterceptor().also {
                    it.level = HttpLoggingInterceptor.Level.BODY
                })
        }
        builder.addInterceptor(InternetConnectionInterceptor(context))
        return builder.build()
    }


    @Provides
    fun githubUrl(): String {
        return "https://api.github.com/"
    }




}