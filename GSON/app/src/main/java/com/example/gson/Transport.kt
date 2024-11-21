package com.example.gson

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("services/rest?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")
    suspend fun getImagePage(): Wrapper
}

object RetrofitClient {
    private const val BASE_URL =
        "https://api.flickr.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}

object Transport {
    suspend fun getImagePage(): Wrapper {
        return withContext(Dispatchers.IO) {
            RetrofitClient.apiService.getImagePage()
        }
    }
}