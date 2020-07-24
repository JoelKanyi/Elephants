package com.kanyideveloper.elephants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.kanyideveloper.elephants.MockUtil.getMockPosters
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService : RestInterface= RestClient.client.create(RestInterface::class.java)
        val call = apiService.getElephants()

        call.enqueue(object : retrofit2.Callback<List<Elephant>> {
            override fun onFailure(call: Call<List<Elephant>>, t: Throwable) {
                Toast.makeText(applicationContext,"Error on fetching the data",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Elephant>>,
                response: Response<List<Elephant>>
            ) {
                recyclerView.adapter = ElephantAdapter().apply { addElephantList(response.body()!!) }
                Log.d(TAG,"${response.body()}")
            }
        })

    }
}