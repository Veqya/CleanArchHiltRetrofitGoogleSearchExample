package com.example.data

import com.example.taskgooglesearch.domain.models.SearchModel
import kotlinx.coroutines.flow.Flow

interface SearchStorage {
    fun getSearchListData(searchText:String,requestLimits:Int): Flow<SearchModel>
}