package com.example.cricbuzzassignment

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("matches?apikey=52c86582-48fa-41bc-8c38-3d646d3a19a4")
    fun getProductData() : Call<MyData>
}