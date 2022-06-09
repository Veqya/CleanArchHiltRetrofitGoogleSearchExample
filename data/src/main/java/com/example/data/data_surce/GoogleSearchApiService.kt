package com.example.taskgooglesearch.data.data_surce


import com.example.taskgooglesearch.data.model.SearchModelUI
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Headers

import retrofit2.http.Path

interface GoogleSearchApiService {
    //max query size is 30
    @Headers(
        "X-User-Agent: mobile",
        "X-Proxy-Location: EU",
        "X-RapidAPI-Key: ab57009ce6msh005bde61a3e4107p1526e7jsnde809264bc83",
        "X-RapidAPI-Host: google-search3.p.rapidapi.com"
    )
    @GET("api/v1/search/q={searchText}&num={requestLimits}")
      fun getGoogleSearchModel(
        @Path("searchText") searchText: String,
        @Path("requestLimits") requestLimits: Int
    ): Flow<SearchModelUI>

}
