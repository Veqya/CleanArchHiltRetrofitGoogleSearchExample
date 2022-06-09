package com.example.taskgooglesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskgooglesearch.domain.models.SearchModel
import com.example.taskgooglesearch.domain.usecase.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(private val useCases: UseCases):ViewModel() {
    private val _searchModelLiveData:MutableLiveData<SearchModel> = MutableLiveData()
    val  modelLiveData:LiveData<SearchModel> = _searchModelLiveData

    fun searchData(searchText:String) {
        viewModelScope.launch(Dispatchers.IO) {
        useCases.getSearchListUseCase.execute(searchText).collect{searchModel->
            _searchModelLiveData.postValue(searchModel)
        }
        }
    }
}