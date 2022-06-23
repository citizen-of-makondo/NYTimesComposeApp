package com.alexilinskiy.nytimescomposeapp.model

data class Section(val showName: String, val requestName: String, var isChecked: Boolean)

object SectionList {
    val sections = listOf(
        Section("Arts", "arts", false),
        Section("Automobiles", "automobiles", false),
        Section("Books", "books", false),
        Section("Business", "business", false),
        Section("Fashion", "fashion", false),
        Section("Food", "food", false),
        Section("Health", "health", false),
        Section("Home", "home", false),
        Section("Insider", "insider", false),
        Section("Magazine", "magazine", false),
        Section("Movies", "movies", false),
        Section("NYregion", "nyregion", false),
        Section("Obituaries", "obituaries", false),
        Section("Opinion", "opinion", false),
        Section("Politics", "politics", false),
        Section("Real estate", "realestate", false),
        Section("Science", "science", false),
        Section("Sports", "sports", false),
        Section("Sunday review", "sundayreview", false),
        Section("Technology", "technology", false),
        Section("Theater", "theater", false),
        Section("T-magazine", "t-magazine", false),
        Section("Travel", "travel", false),
        Section("Upshot", "upshot", false),
        Section("US", "us", false),
        Section("World", "world", false)
    )
}