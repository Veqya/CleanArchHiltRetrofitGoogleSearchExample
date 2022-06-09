package com.example.taskgooglesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.data.repositery.SearchRepositoryImpl
import com.example.data.retrofit.SearchStorageImpl
import com.example.taskgooglesearch.data.data_surce.GoogleSearchApiService
import com.example.taskgooglesearch.domain.usecase.GetSearchListUseCase
import com.example.taskgooglesearch.domain.usecase.UseCases

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val useCases = UseCases(GetSearchListUseCase(SearchRepositoryImpl(SearchStorageImpl(GoogleSearchApiService.getGoogleSearchModel()))))

    }
}