package com.example.myprojectplus.model.loginModel

import com.example.myprojectplus.data.AllUsers

class AccountModel : mAccountModel {
    var mUsername : String = ""
    var mPassword : String = ""
    var mUsersMap : HashMap<String, AllUsers> = HashMap()

    override fun checkUsername(username: String) : Boolean{
        if (username.length > 10) return false
        return true
    }

    override fun checkPassword(password: String) : Boolean{
        if (password.length > 10) return false
        return true
    }

    override fun setUsername(username: String) {
        mUsername = username
    }

    override fun setPassword(password: String) {
        mPassword = password
    }

    override fun save() {
        mUsersMap[mUsername] = AllUsers(mUsername, mPassword)
    }

    override fun load(username: String): AllUsers {
        return mUsersMap[username]!!
    }


}