package com.iamsdt.dragger2demo.data

import com.iamsdt.dragger2demo.data.pojo.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 5:38 PM
 */

interface MovieApiService{
    //CONFIGURATIONS
    @GET("3/discover/movie?sort_by=popularity.desc")
    fun getList(@Query("api_key") apiKey: String):Call<Movies>

    companion object {
        val BASE_URL = "http://api.themoviedb.org/"
    }
}