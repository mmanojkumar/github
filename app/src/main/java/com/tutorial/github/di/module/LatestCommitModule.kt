package com.tutorial.github.di.module

import androidx.lifecycle.MutableLiveData

import com.tutorial.github.commits.latest.contract.ILatestCommitContract
import com.tutorial.github.commits.latest.contract.LatestCommitInteractor
import com.tutorial.github.commits.latest.data.network.GitHubRestClient
import com.tutorial.github.commits.latest.data.model.LatestCommit
import com.tutorial.github.commits.latest.data.repository.GitHubDataRepository
import com.tutorial.github.commits.latest.data.repository.LatestCommitRepository
import com.tutorial.github.di.scope.LatestCommitScope
import dagger.Module
import dagger.Provides


@Module
class LatestCommitModule{

    @Provides
    @LatestCommitScope
    fun latestCommitInteractor(latestCommitRepository: LatestCommitRepository<List<LatestCommit>>): ILatestCommitContract.
    ILatestCommitInteractor<ILatestCommitContract
    .Result<MutableLiveData<List<LatestCommit>>, MutableLiveData<Throwable>>> {
        return LatestCommitInteractor(
            latestCommitRepository
        )
    }

    @Provides
    @LatestCommitScope
    fun latestCommitRepository(gitHubRestClient: GitHubRestClient):
            LatestCommitRepository<List<LatestCommit>> {
        return GitHubDataRepository(gitHubRestClient)
    }


}