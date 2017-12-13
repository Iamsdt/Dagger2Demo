package com.iamsdt.dragger2demo.dragger.module

import android.content.Context
import com.iamsdt.dragger2demo.dragger.scopes.ApiServiceScope
import dagger.Module
import dagger.Provides

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 7:33 PM
 */

@Module
class ContextModule(context:Context){

    private val mContext = context

    @Provides
    @ApiServiceScope
    fun getContext():Context = mContext
}