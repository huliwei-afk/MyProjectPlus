package com.example.myprojectplus.adapter.NewestAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myprojectplus.R
import com.example.myprojectplus.upView.newestView.NewestFragment

class BannerAdapter(var imageList: List<Int>, var newestFragment: NewestFragment) : RecyclerView.Adapter<BannerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_newest_banner_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (position % 3) {
            0 -> Glide.with(newestFragment).load(imageList[0]).into(holder.imageView)
            1 -> Glide.with(newestFragment).load(imageList[1]).into(holder.imageView)
            2 -> Glide.with(newestFragment).load(imageList[2]).into(holder.imageView)
        }
    }

    override fun getItemCount(): Int {
        //实现无限轮播
        return Int.MAX_VALUE
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.banner_item_image)

    }
}