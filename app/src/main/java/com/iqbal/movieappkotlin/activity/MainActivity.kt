package com.iqbal.movieappkotlin.activity

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.iqbal.movieappkotlin.adapter.MovieAdapter
import com.iqbal.movieappkotlin.model.Movie
import com.iqbal.movieappkotlin.network.ApiRepository
import com.iqbal.movieappkotlin.presenter.MainPresenter
import com.iqbal.movieappkotlin.view.MainView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var rvMovie: RecyclerView
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MovieAdapter
    private var movies: MutableList<Movie> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create Layout
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            rvMovie = recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = GridLayoutManager(ctx, 2)
            }
        }
        adapter = MovieAdapter(movies) {
            startActivity<DetailActivity>(
                "TITLE" to it.title,
                "POSTER" to it.poster,
                "OVERVIEW" to it.overview
            )
        }
        rvMovie.adapter = adapter
        presenter = MainPresenter(this, ApiRepository(), Gson())
        presenter.getMovie()
    }

    override fun showMovie(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
