package com.example.data.mappers

import com.example.data.entities_dto.VehicleDto
import com.example.domain.entities.Vehicle


fun VehicleDto.toDomain(): Vehicle {
    return Vehicle(
        name = this.name ?: "Unknown",
        model = this.model ?: "Unknown",
        manufacturer = this.manufacturer ?: "Unknown",
        costInCredits = this.costInCredits ?: "Unknown",
        length = this.length ?: "Unknown",
        maxSpeed = this.maxSpeed ?: "Unknown"
    )
}

fun List<VehicleDto>.toDomain(): List<Vehicle> {
    return this.map { it.toDomain() }
}