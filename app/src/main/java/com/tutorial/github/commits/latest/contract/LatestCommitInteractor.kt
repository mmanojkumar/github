package com.tutorial.github.commits.latest.contract

import androidx.lifecycle.MutableLiveData
import com.tutorial.github.commits.latest.data.model.LatestCommit
import com.tutorial.github.commits.latest.data.repository.LatestCommitRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class LatestCommitInteractor @Inject constructor(
    private val latestCommitRepository:LatestCommitRepository<List<LatestCommit>>)
    : ILatestCommitContract.
                ILatestCommitInteractor<ILatestCommitContract
                .Result<MutableLiveData<List<LatestCommit>>, MutableLiveData<Throwable>>>{


    override fun getLatestCommits(t: ILatestCommitContract.Result<MutableLiveData<List<LatestCommit>>,
            MutableLiveData<Throwable>>) {
        latestCommitRepository.getLatestCommits().
        subscribeOn(Schedulers.io()).
        observeOn(AndroidSchedulers.mainThread()).
        subscribe(object:SingleObserver<List<LatestCommit>>{
            override fun onSuccess(value: List<LatestCommit>?) {
                t.successLiveData().value = value
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onError(e: Throwable?) {
                t.failureLiveData().value = e
            }
        })

    }


}