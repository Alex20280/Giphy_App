package com.example.main_koin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.main_koin.adapters.AdapterModel
import com.example.main_koin.repository.RepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//https://www.youtube.com/watch?v=EathumJlWh8&ab_channel=PhilippLackner

class MainViewModel(private val repo: RepositoryImpl): ViewModel() {

    val myDataList:  MutableLiveData<MutableList<AdapterModel>> = MutableLiveData()

    fun getMyData(){
        CoroutineScope(Dispatchers.IO).launch {
            myDataList.postValue(repo.getResponse())
        }
    }
}