package com.example.data

import com.google.gson.annotations.SerializedName

data class CharacterResponseDto(
    @SerializedName("results") val results: List<CharacterDto>
)
