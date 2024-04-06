package com.example.go.network

import com.example.go.model.Categories
import com.example.go.model.Meals
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/** База */
private const val BASE_URL = "https://themealdb.com/"

/** Билдим ретрофит */
private val retrofit =
    Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build()

/** Api сайтов для запросов Ретрофита */
interface AppApiService {
    @GET("api/json/v1/1/categories.php")
    suspend fun getCategories(): Categories

    @GET("api/json/v1/1/search.php?s")
    suspend fun getMeals(): Meals
}

/** Публичный Api объект */
object AppApi {
    val retrofitService: AppApiService by lazy {
        retrofit.create(AppApiService::class.java)
    }
}