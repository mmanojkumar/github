package com.tutorial.github.di.component


import androidx.lifecycle.MutableLiveData
import com.tutorial.github.commits.latest.contract.ILatestCommitContract
import com.tutorial.github.commits.latest.data.model.LatestCommit
import com.tutorial.github.commits.latest.data.repository.LatestCommitRepository
import com.tutorial.github.di.module.GitHubViewModelModule
import com.tutorial.github.di.module.LatestCommitModule
import com.tutorial.github.di.scope.LatestCommitScope
import com.tutorial.github.commits.latest.ui.LatestCommitActivity
import dagger.Component



@Component(modules = [GitHubViewModelModule::class, LatestCommitModule::class],
    dependencies = [GitHubNetworkComponent::class])
@LatestCommitScope
interface GitHubLatestCommitComponent{
    fun inject(latestCommitActivity: LatestCommitActivity)
    fun latestCommitInteractor(): ILatestCommitContract.
    ILatestCommitInteractor<ILatestCommitContract
    .Result<MutableLiveData<List<LatestCommit>>, MutableLiveData<Throwable>>>
    fun latestCommitRepository(): LatestCommitRepository<List<LatestCommit>>
}