package com.tutorial.github.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tutorial.github.GitHubApplication
import com.tutorial.github.R
import com.tutorial.github.contract.ILatestCommitContract
import com.tutorial.github.contract.LatestCommitPresenter
import com.tutorial.github.data.model.LatestCommit
import com.tutorial.github.data.network.interceptor.NoInternetException
import com.tutorial.github.databinding.LatestCommitActivityBinding
import kotlinx.android.synthetic.main.latest_commit_activity.*
import kotlinx.android.synthetic.main.latest_commit_activity.view.*
import javax.inject.Inject

class LatestCommitActivity : AppCompatActivity(), ILatestCommitContract.ILatestCommitView {

    @Inject
    lateinit var latestCommitViewModel: LatestCommitPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.latest_commit_activity)

        initDaggerDependencies()
        initView()
        initObserver()
    }

    override fun onResume() {
        super.onResume()
        latestCommitViewModel.loadLatestCommits()
    }

    private fun initDaggerDependencies() {
        (application as GitHubApplication).gitHubLatestCommitComponent.inject(this)
    }

    private fun initView() {
        val activityLatestCommitBinding =
            DataBindingUtil.setContentView<LatestCommitActivityBinding>(
                this,
                R.layout.latest_commit_activity
            )
        activityLatestCommitBinding.latestCommitViewModel = latestCommitViewModel
        activityLatestCommitBinding.lifecycleOwner = this
    }

    private fun initObserver() {
        latestCommitViewModel.latestCommitLiveData.observe(this, Observer {
            hideProgress()
            if (it.isNullOrEmpty()) {
                hideLatestCommits()
                showErrorMessage(getString(R.string.no_result_found))
            } else {
                hideErrorMessage()
                showLatestCommits(it)
            }
        })

        latestCommitViewModel.progressDialogLiveData.observe(this, Observer {
            if (it) {
                hideErrorMessage()
                showProgress()
            } else {
                hideProgress()
            }
        })

        latestCommitViewModel.failureLiveData.observe(this, Observer {
            if (it != null) {
                hideLatestCommits()
                when(it){
                    is NoInternetException -> {
                        showErrorMessage(getString(R.string.no_internet_connection))
                    }else -> {
                        showErrorMessage(it.message.toString())
                     }
                }

            } else {
                hideErrorMessage()
            }
        })
    }

    override fun showErrorMessage(errorMessage: String) {
        errorView.errorMessage.text = errorMessage
        errorView.visibility = View.VISIBLE
    }


    override fun hideErrorMessage() {
        errorView.errorMessage.text = null
        errorView.visibility = View.GONE
    }

    override fun hideProgress() {
        loadingProgressView.visibility = View.GONE
    }

    override fun showLatestCommits(latestCommits: List<LatestCommit>) {
        latestCommitRecyclerView.visibility = View.VISIBLE
        latestCommitRecyclerView.adapter = LatestCommitAdapter(latestCommits)
        latestCommitRecyclerView.latestCommitRecyclerView.layoutManager =
            LinearLayoutManager(this)
    }


    override fun hideLatestCommits() {
        latestCommitRecyclerView.visibility = View.VISIBLE
        latestCommitRecyclerView.adapter = LatestCommitAdapter(mutableListOf())
    }

    override fun showProgress() {
        loadingProgressView.visibility = View.VISIBLE
    }

}