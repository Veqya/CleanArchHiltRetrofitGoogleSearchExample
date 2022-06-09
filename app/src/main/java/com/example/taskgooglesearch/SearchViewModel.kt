package com.example.taskgooglesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.taskgooglesearch.domain.models.SearchModel
import com.example.taskgooglesearch.domain.usecase.UseCases

class SearchViewModel(private val useCases: UseCases):ViewModel() {

    fun getSearchModelLiveData(searchText:String,requestLimits:Int):LiveData<SearchModel> =  useCases.getSearchListUseCase.execute(searchText, requestLimits).asLiveData()
}