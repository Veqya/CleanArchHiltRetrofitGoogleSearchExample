package com.example.taskgooglesearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskgooglesearch.domain.usecase.GetSearchListUseCase
import com.example.taskgooglesearch.domain.usecase.UseCases


class FoodViewModelFactory(
   private val useCases:UseCases
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SearchViewModel(
                useCases
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}