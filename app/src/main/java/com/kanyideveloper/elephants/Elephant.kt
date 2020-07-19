package com.kanyideveloper.elephants

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Elephant(
    val name: String,
    val dob: String,
    val species: String,
    val sex: String,
    val image_url: String,
    val affiliation: String,
    val fictional: String,
    val dod: String,
    val description: String
) : Parcelable