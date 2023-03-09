package com.example.testdemo.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testdemo.Adapter.MainAdapter
import com.example.testdemo.Model.*
import com.example.testdemo.R
import com.example.testdemo.databinding.ActivityHomeBinding
import com.example.testdemo.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : AppCompatActivity() {

    private var problemsItem = MutableLiveData<List<ProblemsItem>>()
    private var mAdapter: MainAdapter? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityHomeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)
        var viewModel: HomeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        var email = intent.getStringExtra("Username")
        // Greet the user based on the time of the day
        val date = Date()
        val cal: Calendar = Calendar.getInstance()
        cal.setTime(date)
        val hour: Int = cal.get(Calendar.HOUR_OF_DAY)
        var greeting: String? = null
        if (hour >= 5 && hour < 12) {
            greeting = "Good Morning"
        } else if (hour >= 12 && hour < 17) {
            greeting = "Good Afternoon"
        } else if (hour >= 17 && hour < 21) {
            greeting = "Good Evening"
        } else if (hour >= 21 && hour < 24) {
            greeting = "Good Night"
        }
        tv_username.text = String.format(greeting + " " + email)

        // Get response from Api
        viewModel.makeAPICall()
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))

        // Set Adapter
        mAdapter = MainAdapter(this)
        recyclerView?.adapter = mAdapter
        viewModel.getRecyclerListDataObserver().observe(this, Observer<Medicine> {
            progressbar.visibility = View.GONE
            if (it != null) {
                mAdapter?.setItems(it.problems)
            } else {
                Toast.makeText(this@HomeActivity, "Error in fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}
