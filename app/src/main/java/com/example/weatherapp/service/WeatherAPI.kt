package com.example.weatherapp.service

import com.example.weatherapp.model.WeatherModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

//http://api.openweathermap.org/data/2.5/weather?q=istanbul&appid=YOUR_API_KEY

interface WeatherAPI {
    @GET("data/2.5/weather?&units=metric&appid=YOUR_API_KEY")
    fun getData(@Query("q") cityName: String  ) : Single<WeatherModel>
}