package com.example.main_koin.repository

import com.example.main_koin.adapters.AdapterModel
import com.example.main_koin.data.network.RetrofitProvider


class RepositoryImpl(private val retroProvider: RetrofitProvider ) {

    suspend fun getResponse(): MutableList<AdapterModel>{
        val list = mutableListOf<AdapterModel>()
        val response = retroProvider.api.getResults()
        response.data.map {

            list.add(AdapterModel(it.images.original.url))
        }
        return list
    }
}

/*
class RepositoryImpl {

    suspend fun getResponse(): MutableList<AdapterModel>{
        val list = mutableListOf<AdapterModel>()
        val response = RetrofitProvider.api.getResults()
        response.data.map {

            list.add(AdapterModel(it.images.original.url))
        }
        return list
    }
}
 */