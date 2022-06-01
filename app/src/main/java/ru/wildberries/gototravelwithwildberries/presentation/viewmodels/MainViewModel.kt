package ru.wildberries.gototravelwithwildberries.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.presentation.ApiRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val _allData = MutableLiveData<List<Data>>()
    val allData: LiveData<List<Data>>
        get() = _allData

    fun getAllData() {
        viewModelScope.launch {
            repository.getData().let {
                if (it.isSuccessful) {
                    _allData.postValue(it.body()?.data)
                }
                else {
                    Log.d("checkData", "Fail load data ${it.errorBody()}")
                }
            }
        }
    }
}