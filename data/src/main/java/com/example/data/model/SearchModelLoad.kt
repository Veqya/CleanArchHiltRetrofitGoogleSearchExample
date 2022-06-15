package com.example.taskgooglesearch.data.model

import com.google.gson.annotations.SerializedName


data class SearchModelLoad(
    @SerializedName("results")
    val searchResultsUIList: List<SearchResultLoad>?=null
)
