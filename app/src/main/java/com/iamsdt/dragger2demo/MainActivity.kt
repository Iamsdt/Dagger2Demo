package com.iamsdt.dragger2demo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.iamsdt.dragger2demo.adapter.MyAdapter
import com.iamsdt.dragger2demo.data.MovieApiService
import com.iamsdt.dragger2demo.data.pojo.ResultsItem
import com.iamsdt.dragger2demo.dragger.DaggerMainActivityComponent
import com.iamsdt.dragger2demo.dragger.MainActivityComponent
import com.iamsdt.dragger2demo.dragger.module.MainActivityModule
import com.iamsdt.dragger2demo.utils.Utility
import com.iamsdt.dragger2demo.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(){

    @Inject lateinit var mAdapter: MyAdapter

    @Inject lateinit var apiService:MovieApiService

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private var list:List<ResultsItem> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val manager = GridLayoutManager(this, 1)
        val layoutMode = resources.configuration.orientation

        if (layoutMode == 2) {
            //landscape mode
            manager.spanCount = 2
        }

        mainRecyclerView.layoutManager = manager

        val activityComponent: MainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(MainActivityModule(this))
                .myComponent(MyApplication().get(this).getComponent())
                .build()

        activityComponent.mainActivity(this@MainActivity)

        //don't need to initialize it
        //it will injected
        //mAdapter = activityComponent.getAdapter

        mainRecyclerView.adapter = mAdapter

        //don't need to initialize it
        //it will injected
        viewModel.setApi(apiService)

        viewModel.getAllData()?.observe(this, Observer { allData ->
            if (allData != null && allData.isNotEmpty()) {
                mainProgress.visibility = View.GONE
                mAdapter.swapData(allData)
                list = allData
            }
        })

        if (!Utility.isNetworkAvailable(this)){
            mainRecyclerView.visibility = View.GONE
            main_no_internet.visibility = View.VISIBLE
            mainProgress.visibility = View.GONE
        }

    }
}
