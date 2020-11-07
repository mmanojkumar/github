package com.tutorial.github.data.network

import retrofit2.Retrofit
import javax.inject.Inject


class GitHubRestClient @Inject constructor(val retrofit:Retrofit)