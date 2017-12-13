package com.iamsdt.dragger2demo.dragger.module

import android.content.Context
import com.iamsdt.dragger2demo.dragger.scopes.ApiServiceScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 7:19 PM
 */


@Module(includes = arrayOf(ContextModule::class))
class NetworkModule {

    @Provides
    @ApiServiceScope
    fun getOkHttp(cache: Cache): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .cache(cache)
            .connectTimeout(1, TimeUnit.MINUTES).build()

    @Provides
    @ApiServiceScope
    fun getCache(file: File): Cache = Cache(file, 10 * 1024 * 1024)

    @Provides
    @ApiServiceScope
    fun getFile(context: Context): File = File(context.cacheDir, "okHttp")
}