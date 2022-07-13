package com.example.main_koin.di

import com.example.main_koin.data.network.RetrofitProvider
import com.example.main_koin.repository.RepositoryImpl
import com.example.main_koin.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun dataModule() = module {

    single {
        RetrofitProvider
    }

    single {
        RepositoryImpl(get())
    }

    viewModel {
        MainViewModel(get())
    }
}