package com.example.myprojectplus.baseView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myprojectplus.R
import java.util.*

class FocusFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View =inflater.inflate(R.layout.fragment_focus,container,false);
        return view;
    }


}