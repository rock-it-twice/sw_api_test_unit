package com.example.domain

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}