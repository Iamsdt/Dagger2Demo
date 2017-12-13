package com.iamsdt.dragger2demo.dragger

import com.iamsdt.dragger2demo.data.MovieApiService
import com.iamsdt.dragger2demo.dragger.module.PicassoModule
import com.iamsdt.dragger2demo.dragger.module.ServerModule
import com.iamsdt.dragger2demo.dragger.scopes.ApiServiceScope
import com.squareup.picasso.Picasso
import dagger.Component

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 7:08 PM
 */


//it can be done in the module class
//@Component(modules = arrayOf(ServerModule::class,NetworkModule::class,
//        ContextModule::class))

@ApiServiceScope
@Component(modules = arrayOf(ServerModule::class, PicassoModule::class))
interface MyComponent{
    val getPicasso:Picasso
    val getApiService:MovieApiService
}
