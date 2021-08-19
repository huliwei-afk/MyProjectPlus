package com.example.myprojectplus.adapter.BaseViewAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeFragmentStateAdapter : FragmentStateAdapter {

    private var homeFragments : List<Fragment>

    constructor(fragmentActivity: FragmentActivity, fragments: List<Fragment>) : super(fragmentActivity) {
        this.homeFragments = fragments
    }

    constructor(fragment: Fragment, fragments: List<Fragment>) : super(fragment) {
        this.homeFragments = fragments
    }

    override fun getItemCount(): Int {
        return homeFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return homeFragments[position]
    }
}