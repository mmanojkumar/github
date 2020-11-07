package com.tutorial.github.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ContextModule(private val context:Context){

    @Provides
    @Singleton
   fun context(): Context {
       return context
   }

}