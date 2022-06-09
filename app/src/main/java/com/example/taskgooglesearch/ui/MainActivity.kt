package com.example.taskgooglesearch.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.taskgooglesearch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: SearchViewModel by viewModels ()
        viewModel.modelLiveData.observe(this){ resource ->
            for (searchResult in resource.searchResults) {
                Log.e("TAG", searchResult.title)
            }
        }
        binding.button.setOnClickListener {
        viewModel.searchData("Valod")
        }
    }
}