package com.example.retrofit2mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2mvvm.RecyclerViewViewModel
import com.example.retrofit2mvvm.RecyclerViewViewModelFactory
import com.example.retrofit2mvvm.adapter.PostsRecyclerViewApadpter
import com.example.retrofit2mvvm.databinding.ActivityRecyclerViewBinding
import com.example.retrofit2mvvm.repository.Repository

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var ActivityRecyclerBinding : ActivityRecyclerViewBinding
    private val recyclerViewAdapter by lazy { PostsRecyclerViewApadpter() }
    private lateinit var repository: Repository
    private lateinit var recyclerViewViewModel: RecyclerViewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityRecyclerBinding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(ActivityRecyclerBinding.root)

        repository = Repository()
        val recyclerViewViewModelFactory = RecyclerViewViewModelFactory(repository)
        recyclerViewViewModel = ViewModelProvider(this,recyclerViewViewModelFactory).get(
            RecyclerViewViewModel::class.java)

        setUpRecView()



        ActivityRecyclerBinding.GetPostsButtonId.setOnClickListener {

            recyclerViewViewModel.userPostsAll(Integer.parseInt(ActivityRecyclerBinding.EditTestUserId.text.toString()))

            recyclerViewViewModel.UersPosts.observe(this, Observer { resp->

                if (resp.isSuccessful){
                    resp.body()?.let { recyclerViewAdapter.SetupData(it) }

                }else{

                }

            })

        }

    }

    private fun setUpRecView(){

        ActivityRecyclerBinding.RecyclerViewId.adapter = recyclerViewAdapter
        ActivityRecyclerBinding.RecyclerViewId.layoutManager= LinearLayoutManager(this)

    }
}