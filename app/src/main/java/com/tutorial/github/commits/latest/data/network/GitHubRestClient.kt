package com.tutorial.github.commits.latest.data.network

import retrofit2.Retrofit
import javax.inject.Inject


class GitHubRestClient @Inject constructor(val retrofit:Retrofit)