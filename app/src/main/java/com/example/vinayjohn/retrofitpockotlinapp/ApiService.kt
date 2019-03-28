package com.example.vinayjohn.retrofitpockotlinapp

import com.example.vinayjohn.socialmediademoappkotlin.response.PostsResponseItem
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by vinayjohn on 28/03/19.
 */
interface ApiService {
    @GET("/posts")
    fun getPosts(): Call<List<PostsResponseItem>>
}
