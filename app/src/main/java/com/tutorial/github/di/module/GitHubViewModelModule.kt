package com.tutorial.github.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tutorial.github.commits.latest.contract.LatestCommitPresenter
import com.tutorial.github.di.factory.GitHubViewModelFactory


import com.tutorial.github.di.factory.ViewModelKey

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class GitHubViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LatestCommitPresenter::class)
    abstract fun bindUserViewModel(userViewModel: LatestCommitPresenter): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: GitHubViewModelFactory): ViewModelProvider.Factory
}