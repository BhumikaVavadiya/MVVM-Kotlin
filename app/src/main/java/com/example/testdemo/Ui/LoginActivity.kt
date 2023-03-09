package com.example.testdemo.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.testdemo.R
import com.example.testdemo.Utility.snackbar
import com.example.testdemo.Utility.toast
import com.example.testdemo.databinding.ActivityLoginBinding
import com.example.testdemo.viewModel.AuthListner
import com.example.testdemo.viewModel.AuthViewModel
import com.example.testdemo.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListner {

    lateinit var viewmodel: AuthViewModel
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        viewmodel = ViewModelProvider(this).get(AuthViewModel::class.java)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.viewmodel = viewmodel
        viewmodel.authListner = this
    }

    override fun onSucess(email: String, password: String) {
        // User Successfully  to login
        loginViewModel.insertData(this, email, password)
        toast(email + "  LogIn Successfully")
        root_layout.snackbar(email + "  LogIn Successfully")
    }

    override fun onFailure(msg: String) {
        // User Fail to  login
        toast(msg)
        root_layout.snackbar(msg)
    }
}