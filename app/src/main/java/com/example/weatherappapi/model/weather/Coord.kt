package com.example.weatherappapi.model.weather

import com.google.gson.annotations.SerializedName

data class Coord (
    @SerializedName("lon") var lng: Double? = null,
    @SerializedName("lat") var lat: Double? = null
)