package com.kanyideveloper.elephants

import retrofit2.Call
import retrofit2.http.GET

interface RestInterface {

    @GET("elephants/")
    fun getElephants(): Call<List<Elephant>>
}