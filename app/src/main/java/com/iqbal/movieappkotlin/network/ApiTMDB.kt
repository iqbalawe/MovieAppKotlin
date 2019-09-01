package com.iqbal.movieappkotlin.network

import com.iqbal.movieappkotlin.BuildConfig.API_KEY
import com.iqbal.movieappkotlin.BuildConfig.BASE_URL

object ApiTMDB {
    fun getMovie(): String {
        return BASE_URL + API_KEY
    }
}