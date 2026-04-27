package com.example.data.mappers

import com.example.data.entities_dto.SpeciesDto
import com.example.domain.entities.Species


fun SpeciesDto.toDomain(): Species {
    return Species(
        name = this.name,
        classification = this.classification
    )
}

fun List<SpeciesDto>.toDomain(): List<Species> {
    return this.map { it.toDomain() }
}