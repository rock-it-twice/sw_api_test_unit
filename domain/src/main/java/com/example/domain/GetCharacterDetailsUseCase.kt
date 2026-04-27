package com.example.domain

import com.example.domain.entities.Character
import javax.inject.Inject

class GetCharacterDetailsUseCase @Inject constructor(
    private val repository: CharacterRepository
){

    suspend operator fun invoke(url: String): Result<Character>{
        return try {
            val character = repository.getCharacterByUrl(url)
            Result.success(character)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}