package com.kanyideveloper.elephants

import retrofit2.Call
import retrofit2.http.GET

interface RestInterface {

    @GET("random")
    fun getElephants(): Call<List<Elephant>>
}