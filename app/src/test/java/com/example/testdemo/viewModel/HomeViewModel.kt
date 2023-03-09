package com.example.testdemo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdatabindingrecycleview.Api.RetroInstance
import com.example.mvvmdatabindingrecycleview.Api.RetroService
import com.example.testdemo.Model.Medicine
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel : ViewModel() {
     var medicineData: MutableLiveData<Medicine>
    init {
        medicineData = MutableLiveData()
    }

    @Test
    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI()
        call.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                medicineData.postValue(null)
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("response-------" + response.body())
                println("response_body-------" + response.errorBody())
                println("response_code-------" + response.code())
                var jsonString = response.body()!!.string()
                val errorBody = response.errorBody()
                val errorCode = response.code()
                assert(jsonString != null)
                assert(errorBody == null)
                assert(errorCode == 200)

            }
        })
    }
}

