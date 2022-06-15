package com.example.taskgooglesearch.domain.models

data class SearchResult(
    //some fields are commented
   /* val additional_links: List<AdditionalLink>,
    val cite: Cite,
    val g_review_stars: String,*/
    val title: String?=null,
    val link: String?=null,
    val description: String?=null
)