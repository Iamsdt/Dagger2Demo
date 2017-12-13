package com.iamsdt.dragger2demo.data

import com.iamsdt.dragger2demo.MyApplication
import com.iamsdt.dragger2demo.data.pojo.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 5:38 PM
 */

interface MovieApiService{
    //CONFIGURATIONS
    @GET("/discover/movie?sort_by=popularity.desc")
    fun getList(@Query("api_key") apiKey: String):Call<List<ResultsItem>>

    companion object {
        val BASE_URL = "http://api.themoviedb.org/3/"
    }
}