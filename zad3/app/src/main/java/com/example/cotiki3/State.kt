package com.example.cotiki3

data class State(
    var currentImage: String = "",
    var favoriteImage: String = "",
    var links: List<String> = emptyList()
)
