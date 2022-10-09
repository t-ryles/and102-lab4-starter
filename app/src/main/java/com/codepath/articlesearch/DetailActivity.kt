package com.codepath.articlesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        bylineTextView = findViewById(R.id.mediaByline)
        abstractTextView = findViewById(R.id.mediaAbstract)

        // TODO: Get the extra from the Intent
        val displayArticle = intent.getSerializableExtra(ARTICLE_EXTRA) as Article

        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = displayArticle.headline?.main
        bylineTextView.text = displayArticle.byline?.original
        abstractTextView.text = displayArticle.abstract

        // TODO: Load the media image
        Glide.with(this)
            .load(displayArticle.mediaImageUrl)
            .into(mediaImageView)
    }
}