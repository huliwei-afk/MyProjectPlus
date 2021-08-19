package com.example.myprojectplus.presenter.loginPresenter

import com.example.myprojectplus.model.loginModel.AccountModel
import com.example.myprojectplus.baseView.mLoginView

class SignPresenter(var loginView : mLoginView) : mPresenter {
    private var accountModel = AccountModel()

    override fun saveUser(username: String, password: String) {
        //if(accountModel.checkUsername(username) && accountModel())
    }


    override fun loadUser() {
        TODO("Not yet implemented")
    }

}