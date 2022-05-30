package ru.wildberries.gototravelwithwildberries.presentation

import ru.wildberries.gototravelwithwildberries.data.network.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getData() = apiService.getData()
}