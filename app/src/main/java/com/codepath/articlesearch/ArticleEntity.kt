package com.codepath.articlesearch

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
data class ArticleEntity(
    //Values for database
    //Setting up primary key of each row
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    //Setting the column names and data types for each
    @ColumnInfo(name = "headline") val headline: String?,
    @ColumnInfo(name = "articleAbstract") val articleAbstract: String?,
    @ColumnInfo(name = "byline") val byline: String?,
    @ColumnInfo(name = "mediaImageUrl") val mediaImageUrl: String?
)