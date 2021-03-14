package com.example.breakingbadcharacters.utils

import android.view.View
import com.example.networkmodule.data.model.Character

interface RecycleViewClickListener {
    fun onRecyclerViewItemClick(view: View, character: Character)
}