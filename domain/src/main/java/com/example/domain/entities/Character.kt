package com.example.domain.entities

data class Character(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeworld: Planet,
    val films: List<Film>,
    val species: List<Species>,
    val vehicles: List<Vehicle>,
    val starships: List<Starship>,
    val created: String,
    val edited: String,
    val url: String
    )