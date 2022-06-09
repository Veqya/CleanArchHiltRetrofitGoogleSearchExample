package com.example.data.repositery

import com.example.data.SearchStorage
import com.example.taskgooglesearch.domain.models.SearchModel
import com.example.taskgooglesearch.domain.repositery.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(private val searchStorage: SearchStorage) : SearchRepository {
    override   fun getSearchModel(searchText: String, requestLimits: Int): Flow<SearchModel> =
        searchStorage.getSearchModel(searchText, requestLimits)
}