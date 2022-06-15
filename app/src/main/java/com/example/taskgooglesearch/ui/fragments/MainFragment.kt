package com.example.taskgooglesearch.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Response
import com.example.taskgooglesearch.databinding.FragmentMainBinding
import com.example.taskgooglesearch.ui.SearchViewModel
import com.example.taskgooglesearch.ui.rec_adapters.SearchRecAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {
    val viewModel: SearchViewModel by viewModels()
    private lateinit var recAdapter: SearchRecAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        viewModel.modelLiveData.observe(viewLifecycleOwner) { result ->
            val tempResList = result.searchResults
            recAdapter = SearchRecAdapter(tempResList) {
                val action = MainFragmentDirections.actionMainFragmentToWebViewFragment(it)
                findNavController().navigate(action)
            }
            recyclerView = binding.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = recAdapter
        }
    }

    private fun observemodelLiveDataState() {
        viewModel.modelLiveDataState.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Response.Loading -> binding.loading.visibility = View.VISIBLE
                is Response.Success -> binding.loading.visibility = View.GONE
                is Response.Failure -> {
                    Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}