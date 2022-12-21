package com.example.retrofit2mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2mvvm.R
import com.example.retrofit2mvvm.repository.model.Post
import kotlinx.android.synthetic.main.recycler_one_row_layout.view.*

class PostsRecyclerViewApadpter : RecyclerView.Adapter<PostsRecyclerViewApadpter.ViewHolder>() {
    private var postsEmptyList = emptyList<Post>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_one_row_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.textView_userId.text= postsEmptyList[position].user.toString()
        holder.itemView.textView_PostId.text= postsEmptyList[position].id.toString()
        holder.itemView.textView_Postbody_id.text=postsEmptyList[position].PostBody.toString()
        holder.itemView.textView_Posttitle_id.text=postsEmptyList[position].PostTitle.toString()
    }

    override fun getItemCount(): Int {
       return postsEmptyList.size
    }

    fun SetupData(newList: List<Post>){
        postsEmptyList = newList
        notifyDataSetChanged()
    }
}