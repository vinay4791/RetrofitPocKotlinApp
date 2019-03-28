package com.example.vinayjohn.socialmediademoappkotlin.response

/**
 * Created by vinayjohn on 27/03/19.
 */
data class PostsResponseItem(
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
)