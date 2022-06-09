package com.example.taskgooglesearch.domain.models




data class SearchModel(
    //some fields are commented
   /* val answers: List<String>,
    val device_region: String,
    val device_type: String,
    val image_results: List<Any>,
    val total: Int,
    val ts: Double,*/
    var searchResults: List<SearchResult>
)