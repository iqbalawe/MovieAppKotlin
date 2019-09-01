package com.iqbal.movieappkotlin.view

import com.iqbal.movieappkotlin.model.Movie

interface MainView {
    fun showMovie(data: List<Movie>)
}