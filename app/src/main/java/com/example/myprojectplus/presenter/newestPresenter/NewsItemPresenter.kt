package com.example.myprojectplus.presenter.newestPresenter

import android.util.Log
import android.view.View
import com.example.myprojectplus.data.News
import com.example.myprojectplus.model.newestModel.NewsItemModel
import com.example.myprojectplus.net.HttpRequest
import com.example.myprojectplus.upView.newestView.NewestFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.home_fragment_newest.*

class NewsItemPresenter(val view : NewestFragment) {
    private var newsItemModel = NewsItemModel()
    private var newsList : MutableList<News.DataBean> = ArrayList()


    fun refresh(){
        asyncRequest(newsItemModel.initRetrofit("http://v.juhe.cn/"))

    }

    private fun asyncRequest(completeRetrofit : HttpRequest) {
        completeRetrofit.call("guoji", 50, 30, 0, "2cb4dfb90827deb9158e0a1f4e4f1e45")
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
                            newsList.add(item)
                        }
                    }
                    view.initRecycler(newsList)
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