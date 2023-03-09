package com.example.mvvmdatabindingrecycleview.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
//        https://run.mocky.io/v3/4fe37a6e-3d88-4ec9-af04-759917b8b9dc
        val BASE_URL = "https://run.mocky.io/v3/"
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}