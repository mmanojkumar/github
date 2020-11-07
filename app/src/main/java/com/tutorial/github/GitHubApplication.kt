package com.tutorial.github

import android.app.Application
import com.tutorial.github.di.component.GitHubLatestCommitComponent
import com.tutorial.github.di.component.DaggerGitHubLatestCommitComponent
import com.tutorial.github.di.component.DaggerGitHubNetworkComponent
import com.tutorial.github.di.component.GitHubNetworkComponent
import com.tutorial.github.di.module.ContextModule
import com.tutorial.github.di.module.GitHubNetworkModule
import com.tutorial.github.di.module.LatestCommitModule


class GitHubApplication : Application() {

      lateinit var gitHubComponent:GitHubNetworkComponent
      lateinit var gitHubLatestCommitComponent: GitHubLatestCommitComponent

    override fun onCreate() {
        super.onCreate()

        gitHubComponent = DaggerGitHubNetworkComponent
            .builder()
            .contextModule(ContextModule(this))
            .gitHubNetworkModule(GitHubNetworkModule("https://api.github.com/"))
            .build()

        gitHubLatestCommitComponent =  DaggerGitHubLatestCommitComponent
            .builder()
            .gitHubNetworkComponent(gitHubComponent)
            .latestCommitModule(LatestCommitModule())
            .build()

    }



}