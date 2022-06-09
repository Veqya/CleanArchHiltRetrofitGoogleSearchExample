package com.example.data.data_surce

import com.example.taskgooglesearch.data.data_surce.GoogleSearchApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.thdev.network.flowcalladapterfactory.FlowCallAdapterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://google-search3.p.rapidapi.com/"
    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(FlowCallAdapterFactory())
        .build()
    val apiService: GoogleSearchApiService = getRetrofit().create(GoogleSearchApiService::class.java)
}