package com.example.tp5

import com.example.tp5.model.ForecastListResponse.ForeCastListResponse
import com.example.tp5.model.apiResponses.WeatherResponse
import retrofit2.Call
import retrofit2.http.*

interface WeatherAPI {
    @GET("weather?APPID=17db59488cadcad345211c36304a9266&units=metric")
    fun getWeather(@Query("q") location: String) : Call<WeatherResponse>

    @GET("forecast/daily?APPID=17db59488cadcad345211c36304a9266&units=metric")
    fun getForecast(@Query("q") location: String) : Call<ForeCastListResponse>
}