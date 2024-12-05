package com.example.mydialer

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("u/0/uc?id=1-KO-9GA3NzSgIc1dkAsNm8Dqw0fuPxcR&export=download")
    suspend fun getItems(): List<Contact>
}

object RetrofitClient {
    private const val BASE_URL =
        "https://drive.google.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}

object Transport {
    suspend fun getContacts(): List<Contact> {
        return withContext(Dispatchers.IO) {
            RetrofitClient.apiService.getItems()
        }
    }
}