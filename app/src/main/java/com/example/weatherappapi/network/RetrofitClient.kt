package com.example.weatherappapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private var apiService: IApiService?= null
        fun getInstance(): IApiService{
            //Api service with baseurl and GsonConvertorFactory
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IApiService::class.java)

            }
            return apiService!!
        }
    }
}