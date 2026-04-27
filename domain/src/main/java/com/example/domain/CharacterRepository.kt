package com.example.domain

import com.example.domain.entities.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getCharacterByUrl(url: String): Character
}