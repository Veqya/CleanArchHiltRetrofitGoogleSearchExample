package com.example.data.repositery

import com.example.data.SearchStorage
import com.example.taskgooglesearch.domain.models.SearchModel
import com.example.taskgooglesearch.domain.repositery.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(private val searchStorage: SearchStorage) : SearchRepository {
    override fun getSearchList(searchText: String, requestLimits: Int): Flow<SearchModel> =
        searchStorage.getSearchListData(searchText, requestLimits)

}