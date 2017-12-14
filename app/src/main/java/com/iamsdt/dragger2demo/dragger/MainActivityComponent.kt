package com.iamsdt.dragger2demo.dragger

import com.iamsdt.dragger2demo.MainActivity
import com.iamsdt.dragger2demo.adapter.MyAdapter
import com.iamsdt.dragger2demo.data.MovieApiService
import com.iamsdt.dragger2demo.dragger.module.MainActivityModule
import com.iamsdt.dragger2demo.dragger.scopes.ActivityScope
import dagger.Component
import dagger.Provides

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 11:54 PM
 */

@ActivityScope
@Component(modules = arrayOf(MainActivityModule::class),
        dependencies = arrayOf(MyComponent::class))
interface MainActivityComponent {

    //just comment out his
    //I use inject
//    val getAdapter: MyAdapter
//    val getApiService: MovieApiService

    fun mainActivity(mainActivity:MainActivity)
}