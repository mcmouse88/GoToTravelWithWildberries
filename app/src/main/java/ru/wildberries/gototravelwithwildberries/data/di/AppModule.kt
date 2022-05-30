package ru.wildberries.gototravelwithwildberries.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.wildberries.gototravelwithwildberries.data.network.ApiService
import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.Urls.BASE_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun getBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun providersRetrofit(baseUrl: String): ApiService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}