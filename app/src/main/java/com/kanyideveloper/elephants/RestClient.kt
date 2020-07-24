package com.kanyideveloper.elephants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient{
    private  val BASE_URL = "https://elephant-api.herokuapp.com"
    private var mRetrofit: Retrofit? = null

    val client: Retrofit
        get() {
            if (mRetrofit == null){
                mRetrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            }
            return this.mRetrofit!!
        }
}