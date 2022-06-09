package com.example.data.retrofit

import com.example.data.SearchStorage
import com.example.taskgooglesearch.data.data_surce.GoogleSearchApiService
import com.example.taskgooglesearch.data.model.SearchModelUI
import com.example.taskgooglesearch.domain.models.SearchModel
import com.example.taskgooglesearch.domain.models.SearchResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class SearchStorageImpl(private val api: GoogleSearchApiService) : SearchStorage {


    private fun mapListToRepo(searchModelUI: Flow<SearchModelUI>): Flow<SearchModel> = flow {
        searchModelUI.collect { searchModelUI ->
            val searchResultsUIList = searchModelUI.searchResultsUIList
            val searchResultList = searchResultsUIList.map {
                SearchResult(
                    title = it.title,
                    link = it.link,
                    description = it.description
                )
            }
            emit(SearchModel(searchResultList))
        }
    }.flowOn(Dispatchers.IO)
    override   fun getSearchModel(searchText: String, requestLimits: Int): Flow<SearchModel>  = mapListToRepo(api.getGoogleSearchModel(searchText, requestLimits))
}