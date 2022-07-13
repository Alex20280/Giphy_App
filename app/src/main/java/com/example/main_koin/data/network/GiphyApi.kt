package com.example.main_koin.data.network

import com.example.main_koin.data.model.ResponseModel
import retrofit2.http.GET

interface GiphyApi {

    @GET("gifs/trending?api_key=7zBQQlVcII64xsFEQkYqYJLvD3gKOlZm")
    suspend fun getResults(): ResponseModel
}
