package com.example.data.repository_impl

import android.util.Log
import com.example.data.SwApiService
import com.example.data.mappers.toDomain
import com.example.domain.Character
import com.example.domain.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val api: SwApiService
): CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        val response = api.getCharacters()
        return response.results.toDomain()
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindRepo(impl: CharacterRepositoryImpl): CharacterRepository
}
