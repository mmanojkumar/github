package com.tutorial.github.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.github.R
import com.tutorial.github.commits.latest.data.model.LatestCommit
import kotlinx.android.synthetic.main.commit_view_item.view.*
import kotlinx.android.synthetic.main.key_value.view.*

class LatestCommitAdapter(private val latestCommits:List<LatestCommit>) :
    RecyclerView.Adapter<LatestCommitAdapter.LatestCommitViewHolder>() {

    class LatestCommitViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
         fun setAuthorName(authorName:String){
             view.authorView.label.text = view.resources.getString(R.string.author_name)
             view.authorView.value.text = authorName
         }
        fun setCommitSha(commitSha:String){
            view.commitShaView.label.text = view.resources.getString(R.string.commit_sha)
            view.commitShaView.value.text = commitSha
        }
        fun setCommitMessage(commitMessage:String){
            view.commitMessageView.label.text = view.resources.getString(R.string.commit_message)
            view.commitMessageView.value.text = commitMessage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestCommitViewHolder {
        return LatestCommitViewHolder(View.inflate(parent.context, R.layout.commit_view_item, null))
    }

    override fun getItemCount(): Int {
       return latestCommits.size
    }

    override fun onBindViewHolder(holder: LatestCommitViewHolder, position: Int) {
        val latestCommit = getItem(position)
        latestCommit.commit?.author?.name?.let { holder.setAuthorName(it) }
        latestCommit.sha?.let { holder.setCommitSha(it) }
        latestCommit.commit?.message?.let { holder.setCommitMessage(it) }
    }

    private fun getItem(index:Int): LatestCommit{
        return latestCommits[index]
    }


}