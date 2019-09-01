package com.iqbal.movieappkotlin.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.iqbal.movieappkotlin.BuildConfig.URL_POSTER
import com.iqbal.movieappkotlin.R
import com.iqbal.movieappkotlin.model.Movie
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MovieAdapter(private val result: List<Movie>, private val listener: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieUI().createView(
                AnkoContext.Companion.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun getItemCount(): Int = result.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItems(result[position], listener)
    }
}

class MovieUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(5)
                orientation = LinearLayout.VERTICAL

                imageView {
                    id = R.id.img_poster
                }.lparams {
                    height = dip(250)
                    width = wrapContent
                }
            }
        }
    }
}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imgPoster: ImageView = view.find(R.id.img_poster)

    fun bindItems(movies: Movie, listener: (Movie) -> Unit) {
        Picasso.get().load(URL_POSTER + movies.poster).into(imgPoster)
        Log.d("Image", "url = " + URL_POSTER + movies.poster)
        imgPoster.onClick {
            listener(movies)
        }
    }
}
