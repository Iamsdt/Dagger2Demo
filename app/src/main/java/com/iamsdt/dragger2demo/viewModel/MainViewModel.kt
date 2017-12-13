package com.iamsdt.dragger2demo.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.iamsdt.dragger2demo.BuildConfig
import com.iamsdt.dragger2demo.data.MovieApiService
import com.iamsdt.dragger2demo.data.pojo.Movies
import com.iamsdt.dragger2demo.data.pojo.ResultsItem
import com.iamsdt.dragger2demo.utils.Utility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.util.concurrent.Executors

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 5:53 PM
 */

class MainViewModel(application: Application):AndroidViewModel(application){

    private var allList:MutableLiveData<List<ResultsItem>> ?= null

    private var state = false

    private var api:MovieApiService ?= null

    init {
        state = Utility.isNetworkAvailable(application.baseContext)
    }

    fun getAllData():MutableLiveData<List<ResultsItem>> ?{
        if (allList == null){
            if (state) {
                allList = MutableLiveData()
                getListData()
            }
        }
        return allList
    }

    private fun getListData(){

        if (api == null){
            return
        }

        val executor = Executors.newSingleThreadExecutor()
        executor.submit({
            val data = api!!.getList(BuildConfig.MOVIE_API_KEY)

            data.enqueue(object :Callback<Movies>{
                override fun onResponse(call: Call<Movies>?, response: Response<Movies>?) {
                    if (response!!.isSuccessful){
                        val dataList = response.body()?.results
                        allList?.postValue(dataList)
                        Timber.i(dataList?.size.toString())
                    }
                }

                override fun onFailure(call: Call<Movies>?, t: Throwable?) {
                    Timber.wtf(t,"data not found")
                }

            })
        })
    }

    fun setApi(nApi:MovieApiService?){
        api = nApi
    }

}