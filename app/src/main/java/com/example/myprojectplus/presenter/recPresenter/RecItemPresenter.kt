package com.example.myprojectplus.presenter.recPresenter

import android.util.Log
import com.example.myprojectplus.data.News
import com.example.myprojectplus.model.newestModel.NewsItemModel
import com.example.myprojectplus.model.recModel.RecItemModel
import com.example.myprojectplus.net.HttpRequest
import com.example.myprojectplus.upView.newestView.NewestFragment
import com.example.myprojectplus.upView.recommendView.recTab.FashionFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RecItemPresenter(val view : FashionFragment) {
    private var recItemModel = RecItemModel()
    private var fashionList : MutableList<News.DataBean> = ArrayList()


    fun refresh(){
        asyncRequest(recItemModel.initRetrofit("http://v.juhe.cn/"))

    }

    private fun asyncRequest(completeRetrofit : HttpRequest) {
        completeRetrofit.call("yule", 50, 30, 0, "2cb4dfb90827deb9158e0a1f4e4f1e45")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<News> {
                override fun onSubscribe(d: Disposable?) {
                    Log.d("request", "onSubscribe")

                }

                override fun onNext(news: News?) {
                    Log.d("request", "onNext")
                    var newsDataBean : List<News.DataBean>? = news?.result?.data

                    if (newsDataBean != null) {
                        for(item in newsDataBean){
                            fashionList.add(item)
                        }
                    }
                    view.initRecycler(fashionList)
                    view.endProgress()
                }

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                }

                override fun onComplete() {

                }
            })
    }
}