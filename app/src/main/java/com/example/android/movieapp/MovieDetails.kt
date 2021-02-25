package com.example.android.movieapp

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val actionbar :ActionBar? = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar!!.setDisplayShowHomeEnabled(true)
        var intent =intent
        val Imgview =intent.getIntExtra("iImageView",0)
        val title =intent.getStringExtra("Title")
        val Descr =intent.getStringExtra("Descrption")
        actionbar.setTitle(title)
        img_details.setImageResource(Imgview)
        title_movie.setText(title)
        Descr_movie.setText(Descr)

    }
}
