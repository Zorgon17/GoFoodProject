package com.example.go.model

data class Categories(
    val categories: List<Category?>?
) {
    data class Category(
        val strCategory: String?
    )
}