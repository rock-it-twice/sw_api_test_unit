package com.example.domain

import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
){

    suspend operator fun invoke(): Result<List<Character>>{
        return try {
            val characters = repository.getCharacters()
            Result.success(characters)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}