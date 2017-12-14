package com.iamsdt.dragger2demo.dragger.module

import com.iamsdt.dragger2demo.MainActivity
import com.iamsdt.dragger2demo.adapter.MyAdapter
import com.iamsdt.dragger2demo.dragger.scopes.ActivityScope
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 11:43 PM
 */
@Module(includes = arrayOf(ContextModule::class))
class MainActivityModule(private val activity:MainActivity){

    @Provides
    @ActivityScope
    fun getAdapter(picasso: Picasso):MyAdapter
            = MyAdapter(activity,picasso)
}