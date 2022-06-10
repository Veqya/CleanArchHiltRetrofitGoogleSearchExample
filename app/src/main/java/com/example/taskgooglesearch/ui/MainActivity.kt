package com.example.taskgooglesearch.ui

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Response
import com.example.taskgooglesearch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: SearchViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var recAdapter: SearchRecAdapter
    private lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeModelLiveData()
        observemodelLiveDataState()
        val searchView = binding.searchView
        searchView.clearFocus()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.searchData(it) }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })

    }

    private fun observeModelLiveData() {
        viewModel.modelLiveData.observe(this) { result ->
            val tempResList = result.searchResults
            recAdapter = SearchRecAdapter(tempResList){
                Toast.makeText(this, "go brouser", Toast.LENGTH_SHORT).show()
            }
            recyclerView = binding.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = recAdapter
        }
    }
    private fun observemodelLiveDataState() {
        viewModel.modelLiveDataState.observe(this) { response ->
            when (response) {
                is Response.Loading -> binding.loading.visibility = View.VISIBLE
                is Response.Success -> binding.loading.visibility = View.GONE
                is Response.Failure -> {
                    Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}