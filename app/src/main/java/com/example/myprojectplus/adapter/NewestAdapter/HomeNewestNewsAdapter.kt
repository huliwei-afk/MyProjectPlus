package com.example.myprojectplus.adapter.NewestAdapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myprojectplus.R
import com.example.myprojectplus.data.News

class HomeNewestNewsAdapter(var context: Context, var homeNewestNewsList : List<News.DataBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TYPE_NORMAL = 1
    val TYPE_MULTI = 2
    val TYPE_PLUS = 3


    class ViewHolderForNormal(itemView : View) : RecyclerView.ViewHolder(itemView){
        var textNormal : TextView = itemView.findViewById(R.id.home_news_title_normal)
        var imageNormal : ImageView = itemView.findViewById(R.id.home_news_image_normal)
    }

    class ViewHolderForMulti(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textMulti : TextView = itemView.findViewById(R.id.home_news_title_multi)
        var imageMulti1 : ImageView = itemView.findViewById(R.id.home_news_image_multi_1)
        var imageMulti2 : ImageView = itemView.findViewById(R.id.home_news_image_multi_2)
        var imageMulti3 : ImageView = itemView.findViewById(R.id.home_news_image_multi_3)

    }

    class ViewHolderForPlus(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textPlus : TextView = itemView.findViewById(R.id.home_news_title_plus)
        var imagePlus : ImageView = itemView.findViewById(R.id.home_news_image_plus)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.e("Tag","onCreateViewHolder is running")
        when(viewType){
            TYPE_NORMAL -> return ViewHolderForNormal(LayoutInflater.from(parent.context).inflate(R.layout.home_newest_recycler_item_normal, parent, false))
            TYPE_MULTI -> return ViewHolderForMulti(LayoutInflater.from(parent.context).inflate(R.layout.home_newest_recycler_item_multi, parent, false))
        }
        return ViewHolderForPlus(LayoutInflater.from(parent.context).inflate(R.layout.home_newest_recycler_item_plus, parent, false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var newsData = homeNewestNewsList[position]
        Log.e("MainAc","onBindViewHolder is running")
        if (holder is ViewHolderForNormal){
            holder.textNormal.text = newsData.title
            Glide.with(context).load(newsData.thumbnail_pic_s).into(holder.imageNormal)
        }else if (holder is ViewHolderForMulti){
            holder.textMulti.text = newsData.title
            Glide.with(context).load(newsData.thumbnail_pic_s).into(holder.imageMulti1)
            Glide.with(context).load(newsData.thumbnail_pic_s02).into(holder.imageMulti2)
            Glide.with(context).load(newsData.thumbnail_pic_s03).into(holder.imageMulti3)
        }else if(holder is ViewHolderForPlus){
            holder.textPlus.text = newsData.title
            Glide.with(context).load(newsData.thumbnail_pic_s).into(holder.imagePlus)
        }
    }

    override fun getItemCount(): Int {
        return homeNewestNewsList.size
    }

    override fun getItemViewType(position: Int): Int {
        if(position % 2 == 0){
            if(position % 3 == 0){
                return TYPE_PLUS
            }
            return TYPE_NORMAL
        }else{
            return TYPE_MULTI
        }
    }

    fun upDateItem(homeNewestNewsList: List<News.DataBean>){
        this.homeNewestNewsList = homeNewestNewsList
        this.notifyDataSetChanged()
    }
}
