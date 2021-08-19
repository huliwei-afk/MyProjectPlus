package com.example.myprojectplus.net

import com.example.myprojectplus.data.News
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

interface HttpRequest {
    @GET("toutiao/index")
    fun call(@Query("type") type : String,
             @Query("page") page : Int,
             @Query("page_size") page_size : Int,
             @Query("is_filter") is_filter : Int,
             @Query("key") key : String) : Observable<News>

}