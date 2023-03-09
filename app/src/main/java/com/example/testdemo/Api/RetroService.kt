package com.example.mvvmdatabindingrecycleview.Api

import com.example.testdemo.Model.Medicine
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("4fe37a6e-3d88-4ec9-af04-759917b8b9dc")
    fun getDataFromAPI(): Call<ResponseBody>

}
