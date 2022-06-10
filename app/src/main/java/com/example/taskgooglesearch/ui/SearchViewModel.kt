package com.example.taskgooglesearch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.Response
import com.example.taskgooglesearch.domain.models.SearchModel
import com.example.taskgooglesearch.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {
    private val _searchModelLiveData: MutableLiveData<SearchModel> = MutableLiveData()
    val modelLiveData: LiveData<SearchModel> = _searchModelLiveData

    private val _searchModelLiveDataState: MutableLiveData<Response<Boolean>> = MutableLiveData()
    val modelLiveDataState: LiveData<Response<Boolean>> = _searchModelLiveDataState

    fun searchData(searchText: String) {
        _searchModelLiveDataState.postValue(Response.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            _searchModelLiveDataState.postValue(Response.Loading)
            try {
                useCases.getSearchModelUseCase.execute(searchText).collect { searchModel ->
                        _searchModelLiveData.postValue(searchModel)
                        _searchModelLiveDataState.postValue(Response.Success(true))
                }
            }catch (e: Exception) {
                _searchModelLiveDataState.postValue(Response.Failure(e.message.toString()))
                _searchModelLiveDataState.postValue(Response.Success(true))
            }

        }
    }
}