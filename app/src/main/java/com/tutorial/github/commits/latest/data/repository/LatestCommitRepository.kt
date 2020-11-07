package com.tutorial.github.commits.latest.data.repository

import io.reactivex.Single


interface LatestCommitRepository<T> {
    fun  getLatestCommits(): Single<T>
}