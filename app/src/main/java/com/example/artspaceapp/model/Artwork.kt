package com.example.artspaceapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    @DrawableRes val imageResourceId: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val artistResourceId: Int,
    @StringRes val yearResourceId: Int
)