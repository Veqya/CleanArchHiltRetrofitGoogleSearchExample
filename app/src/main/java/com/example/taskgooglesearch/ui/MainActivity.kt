package com.example.taskgooglesearch.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.data.model.Response
import com.example.taskgooglesearch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: SearchViewModel by viewModels()
        viewModel.modelLiveData.observe(this) { result ->
            for (searchResult in result.searchResults) {
                Log.e("TAG", searchResult.title)
            }
        }
        viewModel.modelLiveDataState.observe(this) { response ->
            when (response) {
                is Response.Loading -> binding.loading.visibility = View.VISIBLE
                is Response.Success -> binding.loading.visibility = View.GONE
                is Response.Failure -> {
                    Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.button.setOnClickListener {
            viewModel.searchData("Valod")
        }
    }
}