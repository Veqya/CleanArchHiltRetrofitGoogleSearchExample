package com.example.taskgooglesearch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskgooglesearch.domain.models.SearchModel
import com.example.taskgooglesearch.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor (private val useCases: UseCases):ViewModel() {
    private val _searchModelLiveData:MutableLiveData<SearchModel> = MutableLiveData()
    val  modelLiveData:LiveData<SearchModel> = _searchModelLiveData

    fun searchData(searchText:String) {
        viewModelScope.launch(Dispatchers.IO) {
        useCases.getSearchModelUseCase.execute(searchText).collect{ searchModel->
            _searchModelLiveData.postValue(searchModel)
        }
        }
    }
}