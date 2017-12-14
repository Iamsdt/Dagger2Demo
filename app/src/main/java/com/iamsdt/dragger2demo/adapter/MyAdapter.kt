package com.iamsdt.dragger2demo.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.iamsdt.dragger2demo.DetailsActivity
import com.iamsdt.dragger2demo.MainActivity
import com.iamsdt.dragger2demo.R
import com.iamsdt.dragger2demo.data.pojo.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_list.view.*
import timber.log.Timber

class MyAdapter(context:MainActivity,private val picasso: Picasso?) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var dataList:List<ResultsItem>? = null

    private var mContext:Context? = null


    init {
        mContext = context
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder?, position: Int) {
        val model = dataList!![position]
        val  posterPath = "http://image.tmdb.org/t/p/w185/${model.posterPath}"
        picasso?.load(posterPath)?.fit()!!.into(viewHolder?.imageView)
        viewHolder?.cardView?.setOnClickListener({
            mContext?.startActivity(Intent(mContext, DetailsActivity::class.java)
                    .putExtra(Intent.EXTRA_TEXT, model))
        })

        Timber.i(picasso.toString())
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, ViewType: Int):
            MyViewHolder {

        val view:View = LayoutInflater.from(parent?.context).inflate(R.layout.main_list,parent,false)

        return MyViewHolder(view)
    }

    fun swapData(list: List<ResultsItem>){
        dataList = list

        if (dataList != null){
            notifyDataSetChanged()
        }
    }

    inner class MyViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView){

        val cardView: CardView = itemView.mainListCard
        val imageView: ImageView = itemView.mainListImageView
    }
}
