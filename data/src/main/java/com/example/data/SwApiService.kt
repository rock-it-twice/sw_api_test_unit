package com.example.data

import com.example.data.entities_dto.CharacterDto
import com.example.data.entities_dto.FilmDto
import com.example.data.entities_dto.PlanetDto
import com.example.data.entities_dto.SpeciesDto
import com.example.data.entities_dto.StarshipDto
import com.example.data.entities_dto.VehicleDto
import com.example.domain.entities.Vehicle
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface SwApiService {
    @GET("people/")
    suspend fun getCharacters(): CharacterResponseDto

    @GET
    suspend fun getCharacterByUrl(@Url url: String): CharacterDto

    @GET
    suspend fun getFilmByUrl(@Url url: String): FilmDto

    @GET
    suspend fun getPlanetByUrl(@Url url: String): PlanetDto

    @GET
    suspend fun getSpeciesByUrl(@Url url: String): SpeciesDto

    @GET
    suspend fun getVehicleByUrl(@Url url: String): VehicleDto

    @GET
    suspend fun getStarshipByUrl(@Url url: String): StarshipDto
}