package com.example.artspace

import androidx.annotation.DrawableRes

class DisplayImage(
    @DrawableRes val resource: Int,
    val description: String,
    val title: String,
    val artist: String,
    val year: String,
    val source: String
)

val imageArray = arrayOf<DisplayImage>(
    DisplayImage(
        resource = R.drawable.clio,
        description = "A woman in a dress with her hand on her face",
        title = "Clio",
        artist = "Joseph Fagnani",
        year = "1869",
        source = "https://www.metmuseum.org/art/collection/search/10860"
    ),
    DisplayImage(
        resource = R.drawable.shurlock,
        description = "The portrait of Mrs. Shurlock",
        title = "Mrs. Robert Shurlock Sr.",
        artist = "John Russell",
        year = "1801",
        source = "https://www.metmuseum.org/art/collection/search/437581"
    ),
    DisplayImage(
        resource = R.drawable.declaration,
        description = "A man confessing love to a woman",
        title = "The Declaration of Love",
        artist = "Jean François de Troy",
        year = "1724",
        source = "https://www.metmuseum.org/art/collection/search/438127"
    ),
    DisplayImage(
        resource = R.drawable.vase,
        description = "Vase of flowers with pink background",
        title = "Vase of Flowers",
        artist = "Odilon Redon",
        year = "1906",
        source = "https://www.metmuseum.org/art/collection/search/437382"
    ),
)