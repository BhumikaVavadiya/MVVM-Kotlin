package com.example.testdemo.viewModel



interface AuthListner {
    fun onSucess(email: String,password: String)
    fun onFailure(msg: String)
}