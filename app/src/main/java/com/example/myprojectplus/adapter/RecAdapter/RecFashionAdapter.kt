package com.example.myprojectplus.adapter.RecAdapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myprojectplus.R
import com.example.myprojectplus.data.News
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.JustifyContent

class RecFashionAdapter(var context: Context, var homeNewestNewsList : List<News.DataBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TYPE_NORMAL = 1
    val TYPE_END = 2

    val bottomViewCount : Int = 1

    fun isBottomView(position : Int) : Boolean{
        return bottomViewCount != 0 && position >= getContentItem()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var fashionImage : ImageView = itemView.findViewById(R.id.rec_fashion_img)
        var textDate : TextView = itemView.findViewById(R.id.rec_fashion_date)
        var textTitle : TextView = itemView.findViewById(R.id.rec_fashion_title)
    }

    class ViewHolderForEnd(itemView: View) : RecyclerView.ViewHolder(itemView){
        var flexBox : FlexboxLayout = itemView.findViewById(R.id.flex_box)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            TYPE_NORMAL -> return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_rec_fashion_recycler_item, parent, false))
        }
        return ViewHolderForEnd(LayoutInflater.from(parent.context).inflate(R.layout.home_rec_fashion_recycler_end, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            var newsData = homeNewestNewsList[position]
            holder.textDate.text = newsData.date
            holder.textTitle.text = newsData.title
            Glide.with(context).load(newsData.thumbnail_pic_s).into(holder.fashionImage)
        }else if(holder is ViewHolderForEnd){
            holder.flexBox.apply {
                flexWrap = FlexWrap.WRAP
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.CENTER
            }
            for(i in 0..5){
                var text = TextView(context)
                text.text = "你好你好"
                holder.flexBox.addView(text)
            }
        }
    }

    fun getContentItem() : Int{
        return homeNewestNewsList.size
    }

    override fun getItemCount(): Int {
        return getContentItem() + bottomViewCount
    }

    override fun getItemViewType(position: Int): Int {
        return if(isBottomView(position)){
            TYPE_END
        }else{
            TYPE_NORMAL
        }
    }

}
