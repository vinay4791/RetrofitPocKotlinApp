package com.example.vinayjohn.retrofitpockotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.vinayjohn.socialmediademoappkotlin.response.PostsResponseItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    companion object {
        var BaseUrl = "https://jsonplaceholder.typicode.com"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    /*
    Function for getting data from server. Here we are creating a retrofit instance and using that we are making the api request.
     */
    fun getData() {
        val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(ApiService::class.java)

        val call = service.getPosts()
        call.enqueue(object : Callback<List<PostsResponseItem>> {
            override fun onResponse(call: Call<List<PostsResponseItem>>?, response: Response<List<PostsResponseItem>>?) {
                if (response != null) {
                    if (response.code() == 200) {
                        val postsResponse = response.body()!!
                        populateData(postsResponse)

                    }
                }
            }

            override fun onFailure(call: Call<List<PostsResponseItem>>?, t: Throwable?) {
                Log.d("failure", "failure")
            }
        })
    }

    /*
    Function for populating the recieved data into the recyclerView
     */
    fun populateData(postsResponse: List<PostsResponseItem>) {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = DataAdapter(postsResponse)
    }
}
