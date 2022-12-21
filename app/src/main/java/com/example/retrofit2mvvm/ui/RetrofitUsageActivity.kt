package com.example.retrofit2mvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit2mvvm.RetrofitUsageViewModel
import com.example.retrofit2mvvm.RetrofitUsageViewModelFactory
import com.example.retrofit2mvvm.databinding.ActivityRetrofitusageBinding
import com.example.retrofit2mvvm.repository.Repository
import com.example.retrofit2mvvm.repository.model.Post

class RetrofitUsageActivity : AppCompatActivity() {

    private lateinit var  RetrofitusageBinding : ActivityRetrofitusageBinding
    private lateinit var RetrofitUsageActivityViewModel : RetrofitUsageViewModel
    private lateinit var repository: Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Define View Binding
        RetrofitusageBinding = ActivityRetrofitusageBinding.inflate(layoutInflater)
        setContentView(RetrofitusageBinding.root)
        // Define Repository and ViewModel and ViewModel Factory
        repository = Repository()
        val RetrofitUsageViewModelFactory = RetrofitUsageViewModelFactory(repository)
        RetrofitUsageActivityViewModel = ViewModelProvider(this,RetrofitUsageViewModelFactory).get(RetrofitUsageViewModel::class.java)

        val MyPost =Post("Mostafa","1993","TitleAzzam","BodyAzam")

        RetrofitusageBinding.GetRequestCardButtonId.setOnClickListener {
            RetrofitUsageActivityViewModel.getPosts()
            RetrofitUsageActivityViewModel.PostRequestLiveData.observe(this, Observer {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            })
            RetrofitUsageActivityViewModel.PostRequestLiveData.removeObservers(this)

        }

        RetrofitusageBinding.PostRequestCardButtonId.setOnClickListener {
            RetrofitUsageActivityViewModel.pushPostFieldsParam(5,10,"Mostafa Azzam Title","Mostafa Azzam Body")
            RetrofitUsageActivityViewModel.PostRequestLiveData.observe(this, Observer {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            })
            RetrofitUsageActivityViewModel.PostRequestLiveData.removeObservers(this)
        }

        RetrofitusageBinding.PathParametersCardButtonId.setOnClickListener {
            RetrofitUsageActivityViewModel.getUserPostsQueryParam(5)
            RetrofitUsageActivityViewModel.PostRequestLiveData.observe(this, Observer {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            })
            RetrofitUsageActivityViewModel.PostRequestLiveData.removeObservers(this)
        }

        RetrofitusageBinding.BodyParametersCardButtonId.setOnClickListener {
            RetrofitUsageActivityViewModel.pushPostBodyParam(MyPost)
            RetrofitUsageActivityViewModel.PostRequestLiveData.observe(this, Observer {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            })
            RetrofitUsageActivityViewModel.PostRequestLiveData.removeObservers(this)
        }

        RetrofitusageBinding.QueryMapCardButtonId.setOnClickListener {
            val Map:HashMap<String,String> = HashMap()
            Map.put("_sort","id")
            RetrofitUsageActivityViewModel.getUserPostsQueryMap(5,Map)
            RetrofitUsageActivityViewModel.PostListReuestLiveData.observe(this, Observer {
                Toast.makeText(this,it.body()?.get(0).toString(),Toast.LENGTH_LONG).show()
            })
            RetrofitUsageActivityViewModel.PostRequestLiveData.removeObservers(this)
        }

        RetrofitusageBinding.QueryParametersCardButtonId.setOnClickListener {
            RetrofitUsageActivityViewModel.getUserPostsQueryParam2(10,"_sort","id")
            RetrofitUsageActivityViewModel.PostListReuestLiveData.observe(this, Observer {
                Toast.makeText(this,it.body()?.get(0).toString(),Toast.LENGTH_LONG).show()
            })
            RetrofitUsageActivityViewModel.PostRequestLiveData.removeObservers(this)
        }

        RetrofitusageBinding.DynamicHeadersCardButtonId.setOnClickListener {
            //RetrofitUsageActivityViewModel.pushPostDynamicHeader("123456789") We need Working Api and Change URL To Test
            RetrofitUsageActivityViewModel.PostRequestLiveData.observe(this, Observer {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            })
            RetrofitUsageActivityViewModel.PostRequestLiveData.removeObservers(this)
        }

        RetrofitusageBinding.StaticHeadersCardButtonId.setOnClickListener {
           // RetrofitUsageActivityViewModel.pushPostStaticHeader() We need Working Api and Change URL To Test
            RetrofitUsageActivityViewModel.PostRequestLiveData.observe(this, Observer {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            })
            RetrofitUsageActivityViewModel.PostRequestLiveData.removeObservers(this)
        }

        RetrofitusageBinding.HeaderTextTextviewId.setOnClickListener {

            val RecActivityIntent = Intent(this, RecyclerViewActivity::class.java)

            startActivity(RecActivityIntent)

        }

    }
}