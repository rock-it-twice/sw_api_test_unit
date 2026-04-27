package com.example.data.mappers

import com.example.data.entities_dto.StarshipDto
import com.example.domain.entities.Starship


fun StarshipDto.toDomain(): Starship {
    return Starship(
        name = this.name ?: "Unknown",
        model = this.model ?: "Unknown",
        manufacturer = this.manufacturer ?: "Unknown",
        costInCredits = this.costInCredits ?: "Unknown",
        length = this.length ?: "Unknown",
        maxSpeed = this.maxSpeed ?: "Unknown"
    )
}

fun List<StarshipDto>.toDomain(): List<Starship>{
    return this.map { it.toDomain() }
}