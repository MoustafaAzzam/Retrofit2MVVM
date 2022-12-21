package com.example.retrofit2mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2mvvm.RecyclerViewViewModel
import com.example.retrofit2mvvm.RecyclerViewViewModelFactory
import com.example.retrofit2mvvm.adapter.PostsRecyclerViewApadpter
import com.example.retrofit2mvvm.databinding.ActivityRecyclerViewBinding
import com.example.retrofit2mvvm.repository.Repository

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var activityRecyclerBinding : ActivityRecyclerViewBinding
    private val recyclerViewAdapter by lazy { PostsRecyclerViewApadpter() }
    private lateinit var repository: Repository
    private lateinit var recyclerViewViewModel: RecyclerViewViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRecyclerBinding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(activityRecyclerBinding.root)

        repository = Repository()
        val recyclerViewViewModelFactory = RecyclerViewViewModelFactory(repository)
        recyclerViewViewModel = ViewModelProvider(this,recyclerViewViewModelFactory)[RecyclerViewViewModel::class.java]

        setUpRecView()



        activityRecyclerBinding.GetPostsButtonId.setOnClickListener {

            recyclerViewViewModel.userPostsAll(Integer.parseInt(activityRecyclerBinding.EditTestUserId.text.toString()))

            recyclerViewViewModel.UersPosts.observe(this){ resp->

                if (resp.isSuccessful){
                    resp.body()?.let { recyclerViewAdapter.SetupData(it) }

                }else{
                    //
                }

            }

        }

    }

    private fun setUpRecView(){

        activityRecyclerBinding.RecyclerViewId.adapter = recyclerViewAdapter
        activityRecyclerBinding.RecyclerViewId.layoutManager= LinearLayoutManager(this)

    }
}