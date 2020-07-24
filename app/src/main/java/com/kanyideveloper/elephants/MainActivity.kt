package com.kanyideveloper.elephants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kanyideveloper.elephants.MockUtil.getMockPosters
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = ElephantAdapter().apply { addElephantList(getMockPosters()) }
    }
}