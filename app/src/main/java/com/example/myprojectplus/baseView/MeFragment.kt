package com.example.myprojectplus.baseView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myprojectplus.R
import kotlinx.android.synthetic.main.fragment_me.*

class MeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View =inflater.inflate(R.layout.fragment_me,container,false);
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }
}