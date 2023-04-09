package com.dicoding.myapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Players(
    val name: String,
    val description: String,
    val photo: Int,
    val context: String,
    val appereance: String,
    val goals: String,
    val win: String,
) : Parcelable