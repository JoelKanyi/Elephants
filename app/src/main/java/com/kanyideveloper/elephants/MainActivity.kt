package com.kanyideveloper.elephants

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showDialog()
        val apiService : RestInterface= RestClient.client.create(RestInterface::class.java)
        val call = apiService.getElephants()

        call.enqueue(object : retrofit2.Callback<List<Elephant>> {
            override fun onFailure(call: Call<List<Elephant>>, t: Throwable) {
                Toast.makeText(applicationContext,"Error on fetching the data",Toast.LENGTH_SHORT).show()
                hideDialog()
            }

            override fun onResponse(
                call: Call<List<Elephant>>,
                response: Response<List<Elephant>>
            )
            {
                hideDialog()
                Log.d(TAG,"${response.body()}")
                recyclerView.adapter = ElephantAdapter().apply { addElephantList(response.body()!!) }
            }
        })

    }

    private fun showDialog() {
        my_progressbar.visibility = View.VISIBLE
    }

    private fun hideDialog() {
        if (my_progressbar.visibility === View.VISIBLE) {
            my_progressbar.visibility = View.INVISIBLE
        }
    }

}