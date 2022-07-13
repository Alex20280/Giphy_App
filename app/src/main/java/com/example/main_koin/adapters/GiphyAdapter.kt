package com.example.main_koin.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.main_koin.Utils
import com.example.main_koin.databinding.ItemBinding
import com.example.main_koin.view.DetailsActivity

class GiphyAdapter() :
    RecyclerView.Adapter<GiphyAdapter.ItemViewHolder>() {

    private var mylist = mutableListOf<AdapterModel>()

    class ItemViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val recyclerView = mylist.get(position)

        Glide.with(holder.binding.root.context)
            .asGif()
            .load(recyclerView.url)
            .into(holder.binding.gifImageView);

        holder.binding.gifImageView.setOnClickListener {
            val context = holder.binding.gifImageView.context
            val intent = Intent(context, DetailsActivity::class.java)
            val item = recyclerView.url
            intent.putExtra(Utils.INTENT_TAG, item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mylist.size
    }

    fun setSomeList(list: MutableList<AdapterModel>){
        mylist.addAll(list)
        notifyDataSetChanged()
    }
}