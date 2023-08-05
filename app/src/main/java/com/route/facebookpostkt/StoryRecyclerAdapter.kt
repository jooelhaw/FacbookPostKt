package com.route.facebookpostkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class StoryRecyclerAdapter (items : MutableList<Stories>) : RecyclerView.Adapter<StoryRecyclerAdapter.StoryViewHolder>() {
    var item : MutableList<Stories> = items
    class StoryViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var image_story : ImageView = view.findViewById(R.id.story_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_stories,parent ,false)
        return StoryViewHolder(view)
    }


    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val item = item[position]
        holder.image_story.setImageResource(item.imageId)
    }

    override fun getItemCount(): Int = item.size
}