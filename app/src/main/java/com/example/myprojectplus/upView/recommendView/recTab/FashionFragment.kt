package com.example.myprojectplus.upView.recommendView.recTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myprojectplus.R
import com.example.myprojectplus.adapter.NewestAdapter.HomeNewestNewsAdapter
import com.example.myprojectplus.adapter.RecAdapter.RecFashionAdapter
import com.example.myprojectplus.data.News
import com.example.myprojectplus.presenter.recPresenter.RecItemPresenter
import kotlinx.android.synthetic.main.home_fragment_newest.*
import kotlinx.android.synthetic.main.recommend_fragment_fashion.*

class FashionFragment : Fragment() {

    private var fashionList : List<News.DataBean> = ArrayList()
    private var recPresenter : RecItemPresenter = RecItemPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.recommend_fragment_fashion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recPresenter.refresh()
        initRecycler(fashionList)
    }

    fun initRecycler(fashionList : List<News.DataBean>){
        var gridLayoutManager = GridLayoutManager(context, 2)
        var adapter = context?.let { RecFashionAdapter(it, fashionList) }
        rec_fashion_recycler.layoutManager = gridLayoutManager
        rec_fashion_recycler.adapter = adapter
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return if(adapter!!.isBottomView(position)) {
                    gridLayoutManager.spanCount
                } else{
                    1
                }
            }
        }
    }

    fun endProgress(){
        rec_progress_bar.visibility = View.GONE
    }

}