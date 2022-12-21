package com.example.retrofit2mvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit2mvvm.RetrofitUsageViewModel
import com.example.retrofit2mvvm.RetrofitUsageViewModelFactory
import com.example.retrofit2mvvm.databinding.ActivityRetrofitusageBinding
import com.example.retrofit2mvvm.repository.Repository
import com.example.retrofit2mvvm.repository.model.Post

class RetrofitUsageActivity : AppCompatActivity() {

    private lateinit var  retrofitUsageBinding : ActivityRetrofitusageBinding
    private lateinit var retrofitUsageActivityViewModel : RetrofitUsageViewModel
    private lateinit var repository: Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Define View Binding
        retrofitUsageBinding = ActivityRetrofitusageBinding.inflate(layoutInflater)
        setContentView(retrofitUsageBinding.root)
        // Define Repository and ViewModel and ViewModel Factory
        repository = Repository()
        val retrofitUsageViewModelFactory = RetrofitUsageViewModelFactory(repository)
        retrofitUsageActivityViewModel = ViewModelProvider(this,retrofitUsageViewModelFactory)[RetrofitUsageViewModel::class.java]

        val myPost =Post("Mostafa","1993","TitleAzzam","BodyAzam")

        retrofitUsageBinding.GetRequestCardButtonId.setOnClickListener {
            retrofitUsageActivityViewModel.getPosts()
            retrofitUsageActivityViewModel.getPostsLiveData.observe(this){
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            }
            retrofitUsageActivityViewModel.getPostsLiveData.removeObservers(this)

        }

        retrofitUsageBinding.PostRequestCardButtonId.setOnClickListener {
            retrofitUsageActivityViewModel.pushPostFieldsParam(5,10,"Mostafa Azzam Title","Mostafa Azzam Body")
            retrofitUsageActivityViewModel.pushPostFieldsParamLiveData.observe(this) {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            }
            retrofitUsageActivityViewModel.pushPostFieldsParamLiveData.removeObservers(this)
        }

        retrofitUsageBinding.PathParametersCardButtonId.setOnClickListener {
            retrofitUsageActivityViewModel.getUserPostsQueryParam(5)
            retrofitUsageActivityViewModel.getUserPostsQueryParamListLiveData.observe(this) {
                Toast.makeText(this,it.body()?.get(0)?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            }
            retrofitUsageActivityViewModel.getUserPostsQueryParamListLiveData.removeObservers(this)
        }

        retrofitUsageBinding.BodyParametersCardButtonId.setOnClickListener {
            retrofitUsageActivityViewModel.pushPostBodyParam(myPost)
            retrofitUsageActivityViewModel.pushPostBodyParamLiveData.observe(this) {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            }
            retrofitUsageActivityViewModel.pushPostBodyParamLiveData.removeObservers(this)
        }

        retrofitUsageBinding.QueryMapCardButtonId.setOnClickListener {
            val map:HashMap<String,String> = HashMap()
            map["_sort"] = "id"
            retrofitUsageActivityViewModel.getUserPostsQueryMap(5,map)
            retrofitUsageActivityViewModel.getUserPostsQueryMapListLiveData .observe(this) {
                Toast.makeText(this,it.body()?.get(0).toString(),Toast.LENGTH_LONG).show()
            }
            retrofitUsageActivityViewModel.getUserPostsQueryMapListLiveData.removeObservers(this)
        }

        retrofitUsageBinding.QueryParametersCardButtonId.setOnClickListener {
            retrofitUsageActivityViewModel.getUserPostsQueryParam2(10,"_sort","id")
            retrofitUsageActivityViewModel.getUserPostsQueryParam2ListLiveData.observe(this) {
                Toast.makeText(this,it.body()?.get(0).toString(),Toast.LENGTH_LONG).show()
            }
            retrofitUsageActivityViewModel.getUserPostsQueryParam2ListLiveData.removeObservers(this)
        }

        retrofitUsageBinding.DynamicHeadersCardButtonId.setOnClickListener {
            //RetrofitUsageActivityViewModel.pushPostDynamicHeader("123456789") We need Working Api and Change URL To Test
            retrofitUsageActivityViewModel.pushPostDynamicHeaderLiveData.observe(this) {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            }
            retrofitUsageActivityViewModel.pushPostDynamicHeaderLiveData.removeObservers(this)
        }

        retrofitUsageBinding.StaticHeadersCardButtonId.setOnClickListener {
           // RetrofitUsageActivityViewModel.pushPostStaticHeader() We need Working Api and Change URL To Test
            retrofitUsageActivityViewModel.pushPostStaticHeaderLiveData.observe(this)  {
                Toast.makeText(this,it.body()?.PostTitle.toString(),Toast.LENGTH_LONG).show()
            }
            retrofitUsageActivityViewModel.pushPostStaticHeaderLiveData.removeObservers(this)
        }

        retrofitUsageBinding.HeaderTextTextviewId.setOnClickListener {

            val recActivityIntent = Intent(this, RecyclerViewActivity::class.java)

            startActivity(recActivityIntent)

        }

    }
}