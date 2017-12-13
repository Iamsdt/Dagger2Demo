package com.iamsdt.dragger2demo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.preference.PreferenceManager
import com.iamsdt.dragger2demo.R

/**
* Created by Shudipto Trafder on 6/25/2017.
* at 5:23 PM
*/

class Utility{

    companion object {
        fun isNetworkAvailable(context: Context): Boolean {
            val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val info = manager.activeNetworkInfo

            return info != null && info.isConnectedOrConnecting
        }
    }
}