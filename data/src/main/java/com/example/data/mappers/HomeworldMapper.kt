package com.example.data.mappers

import com.example.data.entities_dto.PlanetDto
import com.example.domain.entities.Planet


fun PlanetDto.toDomain(): Planet {
    return Planet( name = this.name )
}