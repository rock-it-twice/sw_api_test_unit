package com.example.data.mappers

import com.example.data.entities_dto.FilmDto
import com.example.domain.entities.Film

fun FilmDto.toDomain() : Film {

    return Film(
        title = this.title,
        episodeId = this.episodeId,
        openingCrawl = this.openingCrawl,
        director = this.director,
        producer = this.producer,
        releaseDate = this.releaseDate,
    )

}

fun List<FilmDto>.toDomain(): List<Film> {
    return this.map { it.toDomain() }
}