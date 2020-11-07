package com.tutorial.github.commits.latest.data.repository



import com.tutorial.github.commits.latest.data.api.GitHubApi
import com.tutorial.github.commits.latest.data.model.LatestCommit
import com.tutorial.github.commits.latest.data.network.GitHubRestClient
import io.reactivex.Single
import javax.inject.Inject

class GitHubDataRepository
    @Inject constructor(private val gitHubRestClient: GitHubRestClient) :
    LatestCommitRepository<List<LatestCommit>> {

    override fun getLatestCommits(): Single<List<LatestCommit>> {
        return gitHubRestClient.retrofit.create(GitHubApi::class.java).getLatestCommits()
    }


}