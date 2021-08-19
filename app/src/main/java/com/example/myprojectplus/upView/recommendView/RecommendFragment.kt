package com.example.myprojectplus.upView.recommendView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myprojectplus.R
import com.example.myprojectplus.adapter.BaseViewAdapter.HomeFragmentStateAdapter
import com.example.myprojectplus.upView.newestView.NewestFragment
import com.example.myprojectplus.upView.recommendView.recTab.FashionFragment
import com.example.myprojectplus.upView.recommendView.recTab.GameFragment
import com.example.myprojectplus.upView.recommendView.recTab.HealthyFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.home_base_viewpager2
import kotlinx.android.synthetic.main.home_fragment_recommend.*

class RecommendFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View =inflater.inflate(R.layout.home_fragment_recommend,container,false);
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewPagerAndFragment()
    }

    fun initViewPagerAndFragment() {
        var recTitleList : List<String> = listOf("时尚","游戏","健康")
        var fragments : List<Fragment> = listOf(FashionFragment(), GameFragment(),HealthyFragment())
        rec_base_viewpager2.adapter = HomeFragmentStateAdapter(this, fragments)
        rec_base_viewpager2.offscreenPageLimit = 1
        rec_base_viewpager2.isUserInputEnabled = true
        //绑定tab和vp
        TabLayoutMediator(recommend_tab,rec_base_viewpager2) { tab, position -> tab.text = recTitleList[position] }.attach()
        recommend_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //之后再写吧。。。
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}