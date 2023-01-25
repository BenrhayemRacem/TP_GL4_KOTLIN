package com.example.tp5.model.ForecastListResponse

data class City(
    val coord: Coord,
    val country: String,
    val id: Double,
    val name: String,
    val population: Double,
    val timezone: Double
)