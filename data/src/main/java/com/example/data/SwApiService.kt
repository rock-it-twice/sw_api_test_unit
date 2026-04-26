package com.example.data

import retrofit2.http.GET

interface SwApiService {
    @GET("people/")
    suspend fun getCharacters(): CharacterResponseDto
}