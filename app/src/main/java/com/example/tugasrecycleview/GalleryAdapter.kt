package com.example.tugasrecycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasrecycleview.databinding.ItemGalleryBinding

class GalleryAdapter (private val listGallery: List<Gallery>) : RecyclerView.Adapter<GalleryAdapter.ItemGalleryViewHolder>() {
    inner class ItemGalleryViewHolder(private val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Gallery){
            with(binding){
                txtGalleryName.text = data.nameGallery
                imgGallery.setImageResource(data.gallerySource)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemGalleryViewHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemGalleryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listGallery.size
    }

    override fun onBindViewHolder(holder: ItemGalleryViewHolder, position: Int) {
        holder.bind(listGallery[position])
    }
}