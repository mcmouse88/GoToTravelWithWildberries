package ru.wildberries.gototravelwithwildberries.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.wildberries.gototravelwithwildberries.domain.pojo.Travel

interface ApiService {

    @GET("cheap")
    suspend fun getData(): Response<Travel>
}