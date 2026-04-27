package com.example.data.repository_impl

import android.util.Log
import com.example.data.SwApiService
import com.example.data.mappers.toDomain
import com.example.domain.entities.Character
import com.example.domain.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val api: SwApiService
): CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        val response = api.getCharacters()
        return response.results.toDomain()
    }

    override suspend fun getCharacterByUrl(url: String): Character = coroutineScope {

        val startTime = System.currentTimeMillis()

        val characterDto = api.getCharacterByUrl(url)

        val filmsDeferred = characterDto.films.map { url ->
            async { api.getFilmByUrl(url) }
        }

        val homeworldDeferred = async { api.getPlanetByUrl(characterDto.homeworld) }

        val vehiclesDeferred = characterDto.vehicles.map { url ->
            async { api.getVehicleByUrl(url) }
        }

        val starshipsDeferred = characterDto.starships.map { url ->
            async { api.getStarshipByUrl(url) }
        }

        val speciesDeferred = characterDto.species.map { url ->
            async { api.getSpeciesByUrl(url) }
        }

        val netTime = System.currentTimeMillis()
        Log.d("PERF_TAG", "Сеть отработала за: ${netTime - startTime} мс")

        // ожидаем выполнения запросов
        val filmsDtos = filmsDeferred.awaitAll()
        val homeworldDto = homeworldDeferred.await()
        val vehicleDtos = vehiclesDeferred.awaitAll()
        val starshipsDtos = starshipsDeferred.awaitAll()
        val speciesDtos = speciesDeferred.awaitAll()

        // маппим
        val domainFilms = filmsDtos.toDomain()
        val domainHomeworld = homeworldDto.toDomain()
        val domainVehicles = vehicleDtos.toDomain()
        val domainStarships = starshipsDtos.toDomain()
        val domainSpecies = speciesDtos.toDomain()

        return@coroutineScope characterDto.toDomain(
            homeworld = domainHomeworld,
            films = domainFilms,
            vehicles = domainVehicles,
            starships = domainStarships,
            species = domainSpecies
        )
    }
}


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindRepo(impl: CharacterRepositoryImpl): CharacterRepository
}
