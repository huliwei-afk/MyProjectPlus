package com.example.myprojectplus.model.loginModel

import com.example.myprojectplus.data.AllUsers

interface mAccountModel{
    fun checkUsername(username: String) : Boolean
    fun checkPassword(password: String) : Boolean

    fun setUsername(username: String)
    fun setPassword(password: String)

    fun save()
    fun load(username: String): AllUsers
}