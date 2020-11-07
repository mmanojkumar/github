package com.tutorial.github.data.api

import com.tutorial.github.data.model.LatestCommit import io.reactivex.Single
import retrofit2.http.GET

interface GitHubApi {
    @GET("repos/mmanojkumar/swipe-layout-android/commits?sha=develop")
    fun  getLatestCommits(): Single<List<LatestCommit>>
}