package com.example.data.mappers

import com.example.data.CharacterDto
import com.example.domain.Character

// маппер
fun CharacterDto.toDomain() : Character {
    return Character(
        name = name,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        birthYear = birthYear,
        gender = gender,
        homeWorld = homeWorld,
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
fun List<CharacterDto>.toDomain() : List<Character> {
    return this.map { it.toDomain() }
}