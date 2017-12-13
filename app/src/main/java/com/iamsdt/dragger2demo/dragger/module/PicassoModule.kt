package com.iamsdt.dragger2demo.dragger.module

import android.content.Context
import com.iamsdt.dragger2demo.dragger.scopes.ApiServiceScope
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 7:42 PM
 */
@Module(includes = arrayOf(ContextModule::class))
class PicassoModule {

    @Provides
    @ApiServiceScope
    fun getPicasso(context: Context): Picasso
            = Picasso.Builder(context).build()
}