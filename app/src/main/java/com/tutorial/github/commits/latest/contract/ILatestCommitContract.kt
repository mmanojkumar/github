package com.tutorial.github.commits.latest.contract

import com.tutorial.github.commits.latest.data.model.LatestCommit
interface ILatestCommitContract{

    //View
    interface ILatestCommitView{
        fun showLatestCommits(latestCommits: List<LatestCommit>)
        fun hideLatestCommits()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(errorMessage:String)
        fun hideErrorMessage()
    }

    //Interactor
    interface ILatestCommitInteractor<T>{
        fun getLatestCommits(t:T)
    }

    //Result
    interface Result<T, U>{
        fun successLiveData():T
        fun failureLiveData():U
    }

    //Presentation
     interface ILatestCommitPresenter<T>{
        fun loadLatestCommits()
    }

    interface IRouter{
        fun goBack()
    }

}