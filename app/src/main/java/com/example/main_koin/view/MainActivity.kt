package com.example.main_koin.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.main_koin.adapters.GiphyAdapter
import com.example.main_koin.databinding.ActivityMainBinding
import com.example.main_koin.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
  ** The app was developed in Kotlin using MVVM architecture, View binding, Retrofit, Coroutines, Glide and Koin DI.
  ** Recyclerview UI changes based on phone orientation
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val giphyAdapter = GiphyAdapter()

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        initRecyclerView()

    }

    private fun initRecyclerView(){
        val recyclerView = binding.recycler
        giphyAdapter.setHasStableIds(true)
        val snap = LinearSnapHelper()
        recyclerView.adapter = giphyAdapter

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.layoutManager = GridLayoutManager(this, 3)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        snap.attachToRecyclerView(recyclerView)





    }

    private fun getData() {
        //val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getMyData()
        viewModel.myDataList.observe(this) { list ->
            list.let {
                giphyAdapter.setSomeList(it)
            }
        }
    }


}