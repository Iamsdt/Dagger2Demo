package com.iamsdt.dragger2demo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.iamsdt.dragger2demo.adapter.MyAdapter
import com.iamsdt.dragger2demo.data.pojo.ResultsItem
import com.iamsdt.dragger2demo.utils.Utility
import com.iamsdt.dragger2demo.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity(), MyAdapter.ClickListener {

    private var mAdapter: MyAdapter? = null

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

        mAdapter = MyAdapter(this, this)

        mainRecyclerView.adapter = mAdapter

        viewModel.getAllData()?.observe(this, Observer { allData ->
            if (allData != null && allData.isNotEmpty()) {
                mainProgress.visibility = View.GONE
                mAdapter?.swapData(allData)
                list = allData
            }
        })

        if (!Utility.isNetworkAvailable(this)){
            mainRecyclerView.visibility = View.GONE
            main_no_internet.visibility = View.VISIBLE
            mainProgress.visibility = View.GONE
        }

    }

    override fun onItemClick(position: Int) {
        val result = list!![position]
        startActivity(Intent(this@MainActivity,DetailsActivity::class.java)
                .putExtra(Intent.EXTRA_TEXT,result))
    }
}
