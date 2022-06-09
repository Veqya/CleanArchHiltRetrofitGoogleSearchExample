package com.example.taskgooglesearch.domain.usecase

import com.example.taskgooglesearch.domain.repositery.SearchRepository

class GetSearchListUseCase(private var searchRepositoryImpl: SearchRepository) {
      fun execute(searchText:String, requestLimits:Int) = searchRepositoryImpl.getSearchModel(searchText, requestLimits)
}