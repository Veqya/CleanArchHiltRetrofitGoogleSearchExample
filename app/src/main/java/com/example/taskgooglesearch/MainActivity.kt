package com.example.taskgooglesearch

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.data.data_surce.RetrofitBuilder
import com.example.data.repositery.SearchRepositoryImpl
import com.example.data.retrofit.SearchStorageImpl
import com.example.taskgooglesearch.domain.usecase.GetSearchListUseCase
import com.example.taskgooglesearch.domain.usecase.UseCases

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val useCases = UseCases(GetSearchListUseCase(SearchRepositoryImpl(SearchStorageImpl(RetrofitBuilder.apiService))))
        val viewModel:SearchViewModel by viewModels {SearchViewModelFactory(useCases)  }
        viewModel.getSearchModelLiveData("elon musk",30).observe(this){resource ->
            for (searchResult in resource.searchResults) {
                Log.e("TAG", searchResult.title)
            }
        }

    }
}