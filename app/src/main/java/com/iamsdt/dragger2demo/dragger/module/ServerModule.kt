package com.iamsdt.dragger2demo.dragger.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.iamsdt.dragger2demo.data.MovieApiService
import com.iamsdt.dragger2demo.dragger.scopes.ApiServiceScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 7:13 PM
 */

@Module(includes = arrayOf(NetworkModule::class))
class ServerModule {

    @Provides
    @ApiServiceScope
    fun getApiService(retrofit: Retrofit):MovieApiService
            = retrofit.create(MovieApiService::class.java)

    @Provides
    @ApiServiceScope
    fun getGson():Gson = GsonBuilder().create()

    @Provides
    @ApiServiceScope
    fun getRetrofit(okHttpClient: OkHttpClient,gson: Gson):Retrofit = Retrofit.Builder()
            .baseUrl(MovieApiService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
}