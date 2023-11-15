package com.sample.composetutorial.dependency_injection.model

import com.google.gson.annotations.SerializedName
class NewsApi {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("totalResults")
    var totalResults: Int? = null

    @SerializedName("articles")
    var articles: List<Article>? = null
}

class Article {
    @SerializedName("source")
    var source: Source? = null

    @SerializedName("author")
    var author: Any? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("urlToImage")
    var urlToImage: Any? = null

    @SerializedName("publishedAt")
    var publishedAt: String? = null

    @SerializedName("content")
    var content: String? = null
}

class Source {
    @SerializedName("id")
    var id: Any? = null

    @SerializedName("name")
    var name: String? = null
}