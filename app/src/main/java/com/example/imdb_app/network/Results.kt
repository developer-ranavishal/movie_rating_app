package com.example.imdb_app.network

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results(
    val id: Int,
    val original_language: String,
    val original_title: String,       //imp
    val overview: String,
    val popularity: Double,
    val poster_path: String,   //imp
    val release_date: String,  //imp
    val title: String,
    val video: Boolean,
    val vote_average: Double,  //imp
    val vote_count: Int
) : Parcelable