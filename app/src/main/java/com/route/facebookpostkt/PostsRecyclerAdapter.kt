package com.route.facebookpostkt

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Objects

class PostsRecyclerAdapter (items : MutableList<Posts>) : RecyclerView.Adapter<PostsRecyclerAdapter.PostsViewHolder>() {
    var item : MutableList<Posts> = items
    class PostsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var likes_count : TextView = view.findViewById(R.id.like_counter_txt)
        var shares_count : TextView = view.findViewById(R.id.share_count)
        var left_hours : TextView = view.findViewById(R.id.hours_left)
        var image : ImageView = view.findViewById(R.id.post_image)
        var post_txt : TextView = view.findViewById(R.id.post_txt)
        var like_btn : Button = view.findViewById(R.id.like_btn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_posts, parent, false)
        return PostsViewHolder(view)
    }


    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val item = item[position]
        holder.likes_count.text = item.likes_count
        holder.shares_count.text = item.shares_count
        holder.left_hours.text = item.left_hours
        holder.image.setImageResource(item.imageId)
        holder.post_txt.text = item.post_txt
        holder.like_btn.setOnClickListener {
            onButtonClick?.onClick(position, item)
        }
    }


    var onButtonClick : OnItemClick? = null

    interface OnItemClick{
        fun onClick(Position: Int, item : Posts)
    }
    override fun getItemCount(): Int = item.size


}


