package com.example.main_koin.data.network

import com.example.main_koin.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: GiphyApi by lazy {
        retrofit.create(GiphyApi::class.java)
    }


}