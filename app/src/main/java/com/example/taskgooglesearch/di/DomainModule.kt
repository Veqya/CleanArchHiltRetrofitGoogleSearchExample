package com.example.taskgooglesearch.di
import com.example.taskgooglesearch.domain.repositery.SearchRepository
import com.example.taskgooglesearch.domain.usecase.GetSearchModelUseCase
import com.example.taskgooglesearch.domain.usecase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class DomainModule {
    @Provides
    fun provideGetSearchModelUseCase(searchRepository: SearchRepository) =
        GetSearchModelUseCase(searchRepository)

    @Provides
    fun provideUseCases(getSearchModelUseCase: GetSearchModelUseCase) =
        UseCases(getSearchModelUseCase)

}