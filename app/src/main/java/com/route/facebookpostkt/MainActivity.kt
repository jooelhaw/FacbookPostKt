package com.route.facebookpostkt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var postsRecyclerView: RecyclerView
    lateinit var storyRecyclerView: RecyclerView
    lateinit var adapter: PostsRecyclerAdapter
    lateinit var stAdapter: StoryRecyclerAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var storiesLayoutManager : RecyclerView.LayoutManager
    lateinit var postsList : MutableList<Posts>
    lateinit var storiesList: MutableList<Stories>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        postsRecyclerView = findViewById(R.id.rv_posts)
        storyRecyclerView = findViewById(R.id.rv_stories)

        createLists()
        adapter = PostsRecyclerAdapter(postsList)
        stAdapter = StoryRecyclerAdapter(storiesList)
        //layout managers
        layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        storiesLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        adapter.onButtonClick = object : PostsRecyclerAdapter.OnItemClick{
            override fun onClick(Position: Int, item: Posts) {
                Toast.makeText(this@MainActivity,"Like button",Toast.LENGTH_SHORT).show()
                val newLike = item.likes_count.toInt().plus(1)
                postsList[Position].likes_count = newLike.toString()
                adapter.notifyItemChanged(Position)

            }
        }
        postsRecyclerView.itemAnimator = null
        //set layout manager
        postsRecyclerView.layoutManager = layoutManager
        storyRecyclerView.layoutManager = storiesLayoutManager
        //set adapters
        postsRecyclerView.adapter = adapter
        storyRecyclerView.adapter = stAdapter

    }



   fun createLists(){
        postsList = mutableListOf()
       storiesList = mutableListOf()
        for (item in 1..1000){
            postsList.add(Posts(
                likes_count = "" + (getString(R.string.like_counter_txt).toInt()+ item) , shares_count = "" + (item/5).toInt()+ " shares",
                left_hours = "" + getString(R.string.hours_left).toInt()+(0.5*item).toInt() + "h .",
                imageId = R.drawable.fcblogo, post_txt = "" + getString(R.string.post_txt)))

        }
       for (item in 1..50){
           storiesList.add(Stories(imageId = R.drawable.fcblogo))
       }
    }
}