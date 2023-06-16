package com.example.prakmobile.ui.drama

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class drama (
    var name: String = "",
    var detail: String = "",
    var photo: Int = 0
)
    : Parcelable {
    companion object {
        const val EXTRA_FILM = "extra_film"
    }
}