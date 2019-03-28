package com.example.vinayjohn.retrofitpockotlinapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.vinayjohn.socialmediademoappkotlin.response.PostsResponseItem

/**
 * Created by vinayjohn on 28/03/19.
 */
class DataAdapter(val postsData: List<PostsResponseItem>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.data_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postsTitle.text = postsData[position].title
        holder.postsBody.text = postsData[position].body
    }

    override fun getItemCount(): Int = postsData.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postsTitle: TextView = itemView.findViewById(R.id.posts_title)
        val postsBody: TextView = itemView.findViewById(R.id.posts_body)
    }
}