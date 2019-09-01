package com.iqbal.movieappkotlin.activity

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import androidx.core.view.size
import com.iqbal.movieappkotlin.BuildConfig.URL_POSTER
import com.iqbal.movieappkotlin.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    private var tvTitle: String = ""
    private var tvOverview: String = ""
    private var imgPoster: String = ""

    private lateinit var poster: ImageView
    private lateinit var title: TextView
    private lateinit var overview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            poster = imageView {

            }.lparams {
                width = matchParent
                gravity = Gravity.CENTER
                height = dip(450)
            }
            title = textView {
                id = R.id.detailTitle
                textSize = 24F
            }.lparams {
                width = wrapContent
                height = wrapContent
                margin = dip(8)
            }
            overview = textView {
                textSize = 14F
            }.lparams {
                width = wrapContent
                height = wrapContent
            }
        }
        tvTitle = intent.getStringExtra("TITLE")
        tvOverview = intent.getStringExtra("OVERVIEW")
        imgPoster = intent.getStringExtra("POSTER")

        title.text = tvTitle
        overview.text = tvOverview
        Picasso.get().load(URL_POSTER + imgPoster).into(poster)
    }
}
