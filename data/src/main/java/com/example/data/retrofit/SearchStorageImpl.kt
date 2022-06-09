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
    override fun getSearchListData(searchText: String, requestLimits: Int): Flow<SearchModel> = flow {
        val searchModel = api.getGoogleSearchModel(searchText, requestLimits)
        val searchResultsUIList = searchModel.searchResultsUIList
        val searchModelResultList = searchResultsUIList.map { searchResultUI ->
            SearchResult(
                title = searchResultUI.title,
                link = searchResultUI.link,
                description = searchResultUI.description
            )
        }
        emit(SearchModel(searchModelResultList))
    }.flowOn(Dispatchers.IO)

}