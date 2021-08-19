package com.example.myprojectplus.data

import java.io.Serializable

data class News(var reason: String? = null,var result: Result? = null) : Serializable {

    data class Result(var stat: String? = null,var data: List<DataBean>? = null)

    data class DataBean(var uniquekey: String? = null,
                        var title: String? = null,
                        var date: String? = null,
                        var category: String? = null,
                        var author_name: String? = null,
                        var url: String? = null,
                        var thumbnail_pic_s: String? = null,
                        var thumbnail_pic_s02: String? = null,
                        var thumbnail_pic_s03: String? = null) : Serializable
}