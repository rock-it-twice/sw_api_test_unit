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

        val oneTime = System.currentTimeMillis()
        Log.d("PERF_TAG", "getCharByURL отработала за: ${oneTime - startTime} мс")

        val domainFilms = characterDto.films.map { url ->
             api.getFilmByUrl(url).toDomain()
        }

        val twoTime = System.currentTimeMillis()
        Log.d("PERF_TAG", "getFilmByURL отработала за: ${twoTime - oneTime} мс")

        val domainHomeworld = api.getPlanetByUrl(characterDto.homeworld).toDomain()

        val threeTime = System.currentTimeMillis()
        Log.d("PERF_TAG", "getPlanetByURL отработала за: ${threeTime - twoTime} мс")


        val domainVehicles = characterDto.vehicles.map { url ->
             api.getVehicleByUrl(url).toDomain()
        }

        val fourTime = System.currentTimeMillis()
        Log.d("PERF_TAG", "getVehicleByURL отработала за: ${fourTime - threeTime} мс")


        val domainStarships = characterDto.starships.map { url ->
            api.getStarshipByUrl(url).toDomain()
        }

        val fiveTime = System.currentTimeMillis()
        Log.d("PERF_TAG", "getStarshipByURL отработала за: ${fiveTime - fourTime} мс")


        val domainSpecies = characterDto.species.map { url ->
             api.getSpeciesByUrl(url).toDomain()
        }

        val sixTime = System.currentTimeMillis()
        Log.d("PERF_TAG", "getSpeciesByURL отработала за: ${sixTime - fiveTime} мс")

        val netTime = System.currentTimeMillis()
        Log.d("PERF_TAG", "Сеть отработала за: ${netTime - startTime} мс")


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
