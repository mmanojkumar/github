package com.tutorial.github.data.repository

import io.reactivex.Single


interface LatestCommitRepository<T> {
    fun  getLatestCommits(): Single<T>
}