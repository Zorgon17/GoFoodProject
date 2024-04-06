package com.example.go.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("categories")
    val listOfCategories: List<Category>
) {
    data class Category(
        @SerializedName("strCategory")
        val strCategory: String
    )
}
