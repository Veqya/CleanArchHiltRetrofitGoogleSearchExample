package com.example.taskgooglesearch.data.model

import com.google.gson.annotations.SerializedName


data class SearchModelUI(
    @SerializedName("results")
    var searchResultsUIList: List<SearchResultUI>
)
