package com.example.data.entities_dto

import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("title") val title: String,
    @SerializedName("episode_id") val episodeId: Int,
    @SerializedName("opening_crawl") val openingCrawl: String,
    @SerializedName("director") val director: String,
    @SerializedName("producer") val producer: String,
    @SerializedName("release_date") val releaseDate: String
)
