package com.example.networkmodule.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val img: String?,
    val name: String?,
    val portrayed: String?,
    val status: String?
) : Parcelable