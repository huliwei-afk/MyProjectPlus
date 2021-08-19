package com.example.myprojectplus.adapter.RecAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class RecommendFragmentStateAdapter : FragmentStateAdapter {
    private var recFragments : List<Fragment>

    constructor(fragmentActivity: FragmentActivity, fragments: List<Fragment>) : super(fragmentActivity) {
        this.recFragments = fragments
    }

    constructor(fragment: Fragment, fragments: List<Fragment>) : super(fragment) {
        this.recFragments = fragments
    }

    override fun getItemCount(): Int {
        return recFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return recFragments[position]
    }
}