package com.example.data.mappers

import com.example.data.entities_dto.CharacterDto
import com.example.domain.entities.Character
import com.example.domain.entities.Film
import com.example.domain.entities.Planet
import com.example.domain.entities.Species
import com.example.domain.entities.Starship
import com.example.domain.entities.Vehicle

// маппер
fun CharacterDto.toDomain(
    homeworld: Planet = Planet(""),
    films: List<Film> = emptyList(),
    species: List<Species> = emptyList(),
    vehicles: List<Vehicle> = emptyList(),
    starships: List<Starship> = emptyList()
    ) : Character {
    return Character(
        name = name,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        birthYear = birthYear,
        gender = gender,
        homeworld = homeworld,
        films = films,
        species = species,
        vehicles = vehicles,
        starships = starships,
        created = created,
        edited = edited,
        url = url
    )
}

// маппер списка
fun List<CharacterDto>.toDomain() : List<Character> { return this.map { it.toDomain() } }