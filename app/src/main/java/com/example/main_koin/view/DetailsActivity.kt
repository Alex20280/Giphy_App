package com.example.main_koin.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.main_koin.Utils
import com.example.main_koin.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIncomingIntent()

    }

    private fun setImage(data: String?) {
        Glide.with(binding.root.context)
            .asGif()
            .load(data)
            .into(binding.bigImageView);
    }

    private fun getIncomingIntent() {
        val intent: Intent = intent
        val data = intent.getStringExtra(Utils.INTENT_TAG)

        setImage(data)
    }
}