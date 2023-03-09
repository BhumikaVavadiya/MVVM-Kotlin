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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel : ViewModel() {
    lateinit var medicineData: MutableLiveData<Medicine>
    var keyname: String = ""

    init {
        medicineData = MutableLiveData()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<Medicine> {
        return medicineData
    }

    fun getKeyName(): String {
        return keyname
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI()
        call.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                medicineData.postValue(null)
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("response-------" + response.body())
                val gson = GsonBuilder().create()
                if (response.isSuccessful) {
                    var jsonString = response.body()!!.string()
                    val json = JSONObject(jsonString)
                    val keys: JSONArray = json.names()
                    for (i in 0 until keys.length()) {
                        var key1 = keys.getString(i) // Here's your key
                        keyname = key1
                    }
                    var testModel = gson.fromJson(jsonString, Medicine::class.java)
                    medicineData.postValue(testModel)
                } else {
                    medicineData.postValue(null)
                }
            }
        })
    }
}

