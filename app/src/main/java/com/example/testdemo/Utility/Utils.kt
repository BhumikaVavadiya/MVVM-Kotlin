package com.example.testdemo.Utility

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


fun Context.toast(msg: String){
    Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
}
fun View.snackbar(message: String){
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("Ok") {
            snackbar.dismiss()
        }
    }.show()
}

