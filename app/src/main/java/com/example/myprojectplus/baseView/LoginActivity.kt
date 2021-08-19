package com.example.myprojectplus.baseView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.myprojectplus.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() , mLoginView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setInsideStatusBar()



    }

    //设置沉浸式状态栏
    override fun setInsideStatusBar() = window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

    //获取name和pass
    override fun getUsername() : String = login_username.text.toString()
    override fun getPassword() : String = login_password.text.toString()











}


