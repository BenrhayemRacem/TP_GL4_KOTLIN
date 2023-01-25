package com.example.tp5.model.ForecastListResponse

data class ForecastListItem(
    val clouds: Double,
    val deg: Double,
    val dt: Double,
    val feels_like: FeelsLike,
    val gust: Double,
    val humidity: Double,
    val pop: Double,
    val pressure: Double,
    val speed: Double,
    val sunrise: Double,
    val sunset: Double,
    val temp: Temp,
    val weather: List<Weather>
)