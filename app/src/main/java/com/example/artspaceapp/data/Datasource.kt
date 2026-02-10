package com.example.artspaceapp.data

import com.example.artspaceapp.R
import com.example.artspaceapp.model.Artwork

class Datasource {
    fun loadArtworks(): List<Artwork> {
        return listOf<Artwork>(
            Artwork(
                imageResourceId = R.drawable.artwork1,
                titleResourceId = R.string.artwork1_title,
                artistResourceId = R.string.artwork1_artist,
                yearResourceId = R.string.artwork1_year
            ),
            Artwork(
                imageResourceId = R.drawable.artwork2,
                titleResourceId = R.string.artwork2_title,
                artistResourceId = R.string.artwork2_artist,
                yearResourceId = R.string.artwork2_year
            ),
            Artwork(
                imageResourceId = R.drawable.artwork3,
                titleResourceId = R.string.artwork3_title,
                artistResourceId = R.string.artwork3_artist,
                yearResourceId = R.string.artwork3_year
            )
        )
    }
}