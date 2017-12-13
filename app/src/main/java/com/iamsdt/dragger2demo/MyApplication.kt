package com.iamsdt.dragger2demo

import android.app.Activity
import android.app.Application
import com.iamsdt.dragger2demo.data.MovieApiService
import com.iamsdt.dragger2demo.dragger.*
import com.iamsdt.dragger2demo.dragger.module.ContextModule
import com.squareup.picasso.Picasso
import timber.log.Timber

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 5:32 PM
 */

class MyApplication: Application() {

    fun get(activity: Activity): MyApplication = activity.application as MyApplication

    private var picasso:Picasso ?= null
    private var apiService:MovieApiService ?= null
    private var dagger:MyComponent ?= null

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        dagger = DaggerMyComponent.builder()
                .contextModule(ContextModule(this))
                .build()

        picasso = dagger?.getPicasso
        apiService = dagger?.getApiService
    }
    fun getComponent() = dagger
}