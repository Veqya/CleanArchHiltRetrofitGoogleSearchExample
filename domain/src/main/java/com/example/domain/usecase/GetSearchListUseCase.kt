package com.example.taskgooglesearch.domain.usecase

import com.example.taskgooglesearch.domain.repositery.SearchRepository

class GetSearchListUseCase(private var searchRepositoryImpl: SearchRepository) {

      fun execute(searchText:String ) = searchRepositoryImpl.getSearchModel(searchText)
}