package com.example.testdemo.viewModel

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.testdemo.Ui.HomeActivity
import com.example.testdemo.Utility.isValidEmail


class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authListner: AuthListner? = null


    fun onLoginClicked(view: View) {
        if (email.isNullOrEmpty()) {
            authListner?.onFailure("Please enter email")

        } else if (password.isNullOrEmpty()) {
            authListner?.onFailure("Please enter password")
        }
        else if (!isValidEmail(email)) {
            authListner?.onFailure("Please enter valid Email")
        }
        else {
            //Success
            authListner?.onSucess(email!!, password!!)
        }
    }


}






