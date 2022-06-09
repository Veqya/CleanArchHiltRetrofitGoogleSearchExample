package com.example.taskgooglesearch.domain.repositery

import com.example.taskgooglesearch.domain.models.SearchModel
import kotlinx.coroutines.flow.Flow


interface SearchRepository {
      fun getSearchModel(searchText:String="", requestLimits:Int=0): Flow<SearchModel>
}