package com.codepath.articlesearch

import android.app.Application

//Creating instance of our database

class ArticleApplication : Application() {

    //A lazy initialization means we don't create this variable until it needs to be used
    val db by lazy { AppDatabase.getInstance(this) }
}