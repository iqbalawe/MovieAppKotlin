package com.iqbal.movieappkotlin.presenter

import com.google.gson.Gson
import com.iqbal.movieappkotlin.model.MovieResponse
import com.iqbal.movieappkotlin.network.ApiRepository
import com.iqbal.movieappkotlin.network.ApiTMDB
import com.iqbal.movieappkotlin.view.MainView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(
    private val view: MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getMovie() {
        doAsync {
            val data = gson.fromJson(
                apiRepository.requestUrl(ApiTMDB.getMovie()),
                MovieResponse::class.java
            )
            uiThread { view.showMovie(data.results) }
        }
    }
}