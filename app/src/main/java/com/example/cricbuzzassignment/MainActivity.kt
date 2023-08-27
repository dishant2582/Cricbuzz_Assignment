package com.example.cricbuzzassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cricbuzzassignment.teamdata.TeamData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        var hashmap = hashMapOf<Int,String>()

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://cricket.sportmonks.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface2::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<TeamData?> {

            override fun onResponse(call: Call<TeamData?>, response: Response<TeamData?>) {
                //if API call is success, then use API data and show in your app
                var responceBody = response.body()
                // if (productList != null) ke badle = responceBody?.products!!
                val productList = responceBody?.data!!
                print(productList);

                for(x in productList){

                    hashmap.put(x.id,x.name);
                }
            }

            override fun onFailure(call: Call<TeamData?>, t: Throwable) {
                //if API call is fails
                Toast.makeText(this@MainActivity, "API FAILED", Toast.LENGTH_SHORT).show()
            }
        })



        val retrofitBuilder2 = Retrofit.Builder()
            .baseUrl("https://cricket.sportmonks.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData2 = retrofitBuilder2.getProductData()

        retrofitData2.enqueue(object : Callback<MyData?> {

            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                //if API call is success, then use API data and show in your app
                var responceBody = response.body()
                // if (productList != null) ke badle = responceBody?.products!!
                val productList = responceBody?.data!!

                myAdapter = MyAdapter(this@MainActivity, productList, hashmap)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                //if API call is fails
                Toast.makeText(this@MainActivity, "API FAILED", Toast.LENGTH_SHORT).show()
            }
        })
    }
}