package com.example.myprojectplus.baseView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myprojectplus.R
import com.example.myprojectplus.adapter.BaseViewAdapter.HomeFragmentStateAdapter
import com.example.myprojectplus.upView.newestView.NewestFragment
import com.example.myprojectplus.upView.recommendView.RecommendFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() , mBaseView{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View =inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewPagerAndFragment()
    }

    override fun initViewPagerAndFragment() {
        var homeTitleList : List<String> = listOf("最新","推荐")
        var fragments : List<Fragment> = listOf(NewestFragment(), RecommendFragment())
        home_base_viewpager2.adapter = HomeFragmentStateAdapter(this, fragments)
        home_base_viewpager2.offscreenPageLimit = 1
        home_base_viewpager2.isUserInputEnabled = false
        //绑定tab和vp
        TabLayoutMediator(home_tab,home_base_viewpager2) { tab, position -> tab.text = homeTitleList[position] }.attach()
        home_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
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