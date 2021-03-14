package com.example.breakingbadcharacters.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadcharacters.databinding.ItemLayoutBinding
import com.example.networkmodule.data.model.Character

class CharactersAdapter(
    private val list: ArrayList<Character>,
    private val listener: RecycleViewClickListener
) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.character= list[position]
        holder.binding.cardLayout.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.binding.cardLayout, list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}