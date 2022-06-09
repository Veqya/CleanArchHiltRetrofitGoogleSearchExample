package com.example.taskgooglesearch.di

import com.example.data.SearchStorage
import com.example.data.repositery.SearchRepositoryImpl
import com.example.data.retrofit.SearchStorageImpl
import com.example.taskgooglesearch.data.data_surce.SearchApiService
import com.example.taskgooglesearch.domain.repositery.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.thdev.network.flowcalladapterfactory.FlowCallAdapterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    @Provides
    fun providesBaseUrl() : String = "https://google-search3.p.rapidapi.com/"

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL : String) : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(FlowCallAdapterFactory())
        .build()
    @Provides
    @Singleton
    fun provideSearchService(retrofit : Retrofit) : SearchApiService = retrofit.create(SearchApiService::class.java)

    @Singleton
    @Provides
    fun providSearchStorage(api: SearchApiService): SearchStorage = SearchStorageImpl(api)

    @Singleton
    @Provides
    fun provideSearchRepository(searchStorage: SearchStorage): SearchRepository =
        SearchRepositoryImpl(searchStorage)

}