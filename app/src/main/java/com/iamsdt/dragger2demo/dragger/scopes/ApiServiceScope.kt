package com.iamsdt.dragger2demo.dragger.scopes


import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Retention
import javax.inject.Scope

/**
 * Created by Shudipto Trafder on 12/13/2017.
 * at 10:23 PM
 */

@Scope
@Retention(RetentionPolicy.CLASS)
annotation class ApiServiceScope

//prevent multiple instance of object