package com.uktamov.mvpinstagram.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uktamov.mvpinstagram.databinding.ItemLayoutBinding
import com.uktamov.mvpinstagram.databinding.ItemLayoutHBinding
import com.uktamov.mvpinstagram.model.Data

class UserAdapterH : ListAdapter<Data, UserAdapterH.UserViewHolder>(DiffCallBack()){
    private class DiffCallBack:DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.avatar == newItem.avatar
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    inner class UserViewHolder(private val binding: ItemLayoutHBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: Data){
            binding.apply {
                Glide.with(image)
                    .load(data.avatar)
                    .circleCrop()
                    .into(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(ItemLayoutHBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}