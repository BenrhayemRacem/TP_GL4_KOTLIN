package com.example.tp5.model.ForecastListResponse

data class ForeCastListResponse(
    val city: City,
    val cnt: Double,
    val cod: String,
    val list: List<ForecastListItem>,
    val message: Double
)