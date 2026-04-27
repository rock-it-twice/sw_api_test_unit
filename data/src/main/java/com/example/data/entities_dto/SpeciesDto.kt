package com.example.data.entities_dto

import com.example.domain.entities.Character
import com.example.domain.entities.Planet
import com.google.gson.annotations.SerializedName


data class SpeciesDto(
    @SerializedName("name") val name: String,
    @SerializedName("classification") val classification: String
)