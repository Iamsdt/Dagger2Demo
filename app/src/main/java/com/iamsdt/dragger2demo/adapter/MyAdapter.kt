package com.iamsdt.dragger2demo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iamsdt.dragger2demo.MyApplication
import com.iamsdt.dragger2demo.R
import com.iamsdt.dragger2demo.data.pojo.ResultsItem
import kotlinx.android.synthetic.main.main_list.view.*

class MyAdapter constructor(context:Context,clickListener:ClickListener) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var dataList:List<ResultsItem>? = null
    var clickListener:ClickListener? = null

    var mContext:Context? = null


    init {
        mContext = context
        this.clickListener = clickListener
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder?, position: Int) {
        val model = dataList!![position]
        viewHolder?.bindPoster(model)
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

    interface ClickListener{
        fun onItemClick(position:Int)
    }

    inner class MyViewHolder internal constructor(itemView: View) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val cardView = itemView.mainListCard

        init {
            cardView.setOnClickListener(this)
        }

        fun bindPoster(model: ResultsItem){
            val  posterPath = "http://image.tmdb.org/t/p/w185/${model.posterPath}}"

            MyApplication().picasso()?.load(posterPath)?.fit()!!.into(itemView.mainListImageView)
        }

        override fun onClick(v: View) {
            clickListener!!.onItemClick(adapterPosition)
        }
    }
}
