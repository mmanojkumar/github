package com.tutorial.github.commits.latest.data.model

class LatestCommit {
    var sha: String? = null
    var commit: Commit? = null

    class Author {
        var name: String? = null
        var email: String? = null
    }

    class Commit {
        var author: Author? = null
        var message: String? = null
    }
}







