package com.example.cricbuzzassignment

import com.example.cricbuzzassignment.teamdata.TeamData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface2 {

    @GET("api/v2.0/countries?api_token=4fO3NlOnR64OqrPTM64RkHn5rmuvvzkqIxPIjqLDyePcWknJMdsdV9AODhDN&include=")
    fun getProductData() : Call<TeamData>
}