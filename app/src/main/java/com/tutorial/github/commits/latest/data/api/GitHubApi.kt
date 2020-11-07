package com.tutorial.github.commits.latest.data.api

import com.tutorial.github.commits.latest.data.model.LatestCommit import io.reactivex.Single
import retrofit2.http.GET

interface GitHubApi {
    @GET("repos/mmanojkumar/github/commits?sha=master")
    fun  getLatestCommits(): Single<List<LatestCommit>>
}