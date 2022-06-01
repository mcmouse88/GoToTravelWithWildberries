package ru.wildberries.gototravelwithwildberries.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.wildberries.gototravelwithwildberries.domain.pojo.Travel
import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.Urls.END_POINT

interface ApiService {

    @GET(END_POINT)
    suspend fun getData(): Response<Travel>
}