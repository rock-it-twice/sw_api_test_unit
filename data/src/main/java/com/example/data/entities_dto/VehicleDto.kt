package com.example.data.entities_dto

import com.google.gson.annotations.SerializedName

data class VehicleDto(
    @SerializedName("name") val name: String?,
    @SerializedName("model") val model: String?,
    @SerializedName("manufacture") val manufacturer: String?,
    @SerializedName("cost_in_credits") val costInCredits: String?,
    @SerializedName("length") val length: String?,
    @SerializedName("max_atmosphering_speed") val maxSpeed: String?
)
