package com.example.cricbuzzassignment

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/v2.0/fixtures?api_token=4fO3NlOnR64OqrPTM64RkHn5rmuvvzkqIxPIjqLDyePcWknJMdsdV9AODhDN&include=")
    fun getProductData() : Call<MyData>
}