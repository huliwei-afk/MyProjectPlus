package com.example.myprojectplus.model.recModel

import android.util.Log
import com.example.myprojectplus.net.HttpRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RecItemModel {

    fun initRetrofit(baseUrl: String): HttpRequest {

        var level= HttpLoggingInterceptor.Level.BODY
        var httpLoggingInterceptor = HttpLoggingInterceptor { message ->
            if (message != null) {
                Log.d("okHttp日志", message)
            }
        }
        var okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor.setLevel(level))
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .client(okHttpClient)
            .build()

        return retrofit.create(HttpRequest::class.java)
    }
}