package com.tutorial.github.commits.latest.contract

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tutorial.github.commits.latest.contract.ILatestCommitContract
import com.tutorial.github.data.model.LatestCommit
import javax.inject.Inject


class  LatestCommitPresenter @Inject constructor() : ViewModel(),
    ILatestCommitContract.ILatestCommitPresenter<ILatestCommitContract>{

     val latestCommitLiveData = MutableLiveData<List<LatestCommit>>()
     val failureLiveData = MutableLiveData<Throwable>()
     val progressDialogLiveData = MutableLiveData<Boolean>()


    @Inject
    lateinit var latestCommitInteractor:
            ILatestCommitContract.ILatestCommitInteractor<ILatestCommitContract.Result<MutableLiveData<List<LatestCommit>>,
                    MutableLiveData<Throwable>>>

    override fun loadLatestCommits() {
        progressDialogLiveData.value = true
        latestCommitInteractor.getLatestCommits(object:
            ILatestCommitContract.
        Result<MutableLiveData<List<LatestCommit>>, MutableLiveData<Throwable>>{
            override fun successLiveData(): MutableLiveData<List<LatestCommit>> {
                return latestCommitLiveData
            }

            override fun failureLiveData(): MutableLiveData<Throwable> {
               return failureLiveData
            }
        })
    }

}