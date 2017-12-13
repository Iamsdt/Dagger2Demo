package com.iamsdt.dragger2demo

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

class MyApplication : Application() {

    private var picasso:Picasso ?= null
    private var apiService:MovieApiService ?= null

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        val dragger = DaggerMyComponent.builder()
                .contextModule(ContextModule(this))
                .build()

        picasso = dragger.getPicasso
        apiService = dragger.getApiService
    }

    fun getApi() = apiService
    fun picasso() = picasso

}