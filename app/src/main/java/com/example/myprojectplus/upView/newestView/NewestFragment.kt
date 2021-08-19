package com.example.myprojectplus.upView.newestView

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.myprojectplus.R
import com.example.myprojectplus.adapter.NewestAdapter.BannerAdapter
import com.example.myprojectplus.adapter.NewestAdapter.HomeNewestNewsAdapter
import com.example.myprojectplus.data.News
import com.example.myprojectplus.presenter.newestPresenter.NewsItemPresenter
import kotlinx.android.synthetic.main.home_fragment_newest.*

class NewestFragment : Fragment() {

    private var handler : Handler = Handler()
    private var newestPresenter = NewsItemPresenter(this)
    private var newsList : List<News.DataBean> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View =inflater.inflate(R.layout.home_fragment_newest,container,false);
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initIndicatorDots()
        initViewPager()
        newestPresenter.refresh()
        initRecycler(newsList)
        forceRefresh()
    }


    //---------------------banner-------------------------------------
    private fun initIndicatorDots() {
        for (i in 0 until 3) {
            val imageView = ImageView(context)
            if (i == 0) imageView.setBackgroundResource(R.drawable.banner_indicator_selected)
            else imageView.setBackgroundResource(R.drawable.banner_indicator_unselected)
            //为指示点添加间距
            val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.marginEnd = 4
            imageView.layoutParams = layoutParams
            //将指示点添加进容器
            newest_banner_indicator.addView(imageView)
        }
    }

    private fun initViewPager(){
        var imageList = listOf(R.drawable.test1, R.drawable.test2, R.drawable.test3)
        //添加适配器
        newest_banner_viewpager2.adapter = BannerAdapter(imageList,this)
        //设置轮播图初始位置在498,以保证可以手动前翻
        newest_banner_viewpager2.setCurrentItem(498, false)
        newest_banner_viewpager2.isUserInputEnabled = true
        //最后所在的位置设置为500
        var lastPosition = 498
        //注册轮播图的滚动事件监听器
        newest_banner_viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //轮播时，改变指示点
                val current = position % 3
                val last = lastPosition % 3
                newest_banner_indicator.getChildAt(current).setBackgroundResource(R.drawable.banner_indicator_selected)
                newest_banner_indicator.getChildAt(last).setBackgroundResource(R.drawable.banner_indicator_unselected)
                lastPosition = position
            }
        })
    }

    /* 当应用被唤醒时，让轮播图开始轮播 */
    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable,5000)
    }

    /* 当应用被暂停时，让轮播图停止轮播 */
    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }


    private val runnable: Runnable = object : Runnable {
        override fun run() {
            //获得轮播图当前的位置
            var currentPosition: Int = newest_banner_viewpager2.currentItem
            currentPosition++
            newest_banner_viewpager2.setCurrentItem(currentPosition, true)
            handler.postDelayed(this, 5000)
        }
    }

    //---------------------banner-------------------------------------


    //---------------------recyclerView-------------------------------

    fun initRecycler(newsList: List<News.DataBean>){
        newest_recyclerview.layoutManager = LinearLayoutManager(context)
        newest_recyclerview.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        newest_recyclerview.adapter = context?.let { HomeNewestNewsAdapter(it, newsList) }
//        newest_recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener(){
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                newest_swipe_refresh.isEnabled = recyclerView.childCount == 0 || recyclerView.getChildAt(0).top >= 0;
//            }
//        })
    }

    //-----------Progress
    fun showProgress(){
        newest_progress_bar.visibility = View.VISIBLE
    }

    fun endProgress(){
        newest_progress_bar.visibility = View.GONE
    }

    //-------swipe
    private fun forceRefresh(){
        newest_swipe_refresh.setOnRefreshListener {
            handler.postDelayed({
                newest_swipe_refresh.isRefreshing = false
            }, 2000)
        }
    }


}
