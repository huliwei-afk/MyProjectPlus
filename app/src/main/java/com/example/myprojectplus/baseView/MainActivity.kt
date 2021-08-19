package com.example.myprojectplus.baseView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myprojectplus.R
import com.example.myprojectplus.adapter.BaseViewAdapter.MainFragmentStateAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , mBaseView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setInsideStatusBar()
        initRadioGroup()
        initViewPagerAndFragment()
    }

    private fun initRadioGroup(){
        radio_group.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                //滑动时禁止切换动画，确实看着不好看
                R.id.radio_button_home -> activity_viewpager2.setCurrentItem(0, false)
                R.id.radio_button_focus -> activity_viewpager2.setCurrentItem(1, false)
                R.id.radio_button_chat -> activity_viewpager2.setCurrentItem(2, false)
                R.id.radio_button_me -> activity_viewpager2.setCurrentItem(3, false)
            }
        }
    }

    override fun initViewPagerAndFragment(){
        val allFragment : List<Fragment> = listOf(HomeFragment(), FocusFragment(), ChatFragment(), MeFragment())
        activity_viewpager2.adapter = MainFragmentStateAdapter(this, allFragment)
        activity_viewpager2.offscreenPageLimit = 1
        activity_viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                activity_viewpager2.isUserInputEnabled = false
                when(position){
                    0 -> radio_group.check(R.id.radio_button_home)
                    1 -> radio_group.check(R.id.radio_button_focus)
                    2 -> radio_group.check(R.id.radio_button_chat)
                    3 -> radio_group.check(R.id.radio_button_me)
                }
            }

        })
    }

    private fun setInsideStatusBar() = window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
}