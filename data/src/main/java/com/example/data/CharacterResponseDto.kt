package com.example.data

import com.example.data.entities_dto.CharacterDto
import com.google.gson.annotations.SerializedName

data class CharacterResponseDto(
    @SerializedName("results") val results: List<CharacterDto>
)
