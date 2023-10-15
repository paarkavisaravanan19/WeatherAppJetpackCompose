package com.example.weatherappapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappapi.model.MyLatLng
import com.example.weatherappapi.model.forecast.ForecastResult
import com.example.weatherappapi.model.weather.WeatherResult
import com.example.weatherappapi.network.RetrofitClient
import kotlinx.coroutines.launch

enum class STATE{
    LOADING,
    SUCCESS,
    FAILED
}

class MainViewModel : ViewModel(){
    //Control the state of View model
    var state by mutableStateOf(STATE.LOADING)
    //Hold Value from API for Weather info
    var weatherResponse : WeatherResult by mutableStateOf(WeatherResult())
    //Hold Value from API for Forecast  info
    var forecastResponse : ForecastResult by mutableStateOf(ForecastResult())
    var errorMessage : String by mutableStateOf("")

    fun getWeatherByLocation(latLng: MyLatLng)
    {
        viewModelScope.launch {
            state = STATE.LOADING
            val apiService = RetrofitClient.getInstance()
            try{
                val apiResponse = apiService.getWeather(latLng.lat, latLng.lng)
                weatherResponse = apiResponse //update the state
                state = STATE.SUCCESS
            }
            catch(e: Exception)
            {
                errorMessage = e.message!!.toString()
                state = STATE.FAILED
            }
        }
    }


    fun getForecastByLocation(latLng: MyLatLng)
    {
        viewModelScope.launch {
            state = STATE.LOADING
            val apiService = RetrofitClient.getInstance()
            try{
                val apiResponse = apiService.getForecast(latLng.lat, latLng.lng)
                forecastResponse = apiResponse //update the state
                state = STATE.SUCCESS
            }
            catch(e: Exception)
            {
                errorMessage = e.message!!.toString()
                state = STATE.FAILED
            }
        }
    }
















}