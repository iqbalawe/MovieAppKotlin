package com.iqbal.movieappkotlin.network

import java.net.URL

class ApiRepository {
    fun requestUrl(url: String): String {
        return URL(url).readText()
    }
}