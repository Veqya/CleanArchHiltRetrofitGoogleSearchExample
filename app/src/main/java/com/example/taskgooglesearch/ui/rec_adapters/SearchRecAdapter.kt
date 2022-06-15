package com.example.taskgooglesearch.ui.rec_adapters

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskgooglesearch.databinding.SearchItemBinding
import com.example.taskgooglesearch.domain.models.SearchResult

class SearchRecAdapter(
    private val searchResultlList: List<SearchResult>?=null,
    private val onItemClick: (webSiteLink: String) -> Unit

) : RecyclerView.Adapter<SearchRecAdapter.SearchViewHolder>() {


    override fun getItemCount(): Int = searchResultlList?.size ?: 0

    inner class SearchViewHolder(val binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tvLink = binding.tvLink
        val tvTitle = binding.tvTitle
        val tvDescription = binding.tvDescription

        fun bind(searchResult: SearchResult) {
            tvLink.text = searchResult.link
            tvTitle.text = searchResult.title
            tvDescription.text = searchResult.description

            tvTitle.setOnClickListener {
                if (tvLink.text.toString().isNotEmpty()) {
                    onItemClick.invoke(tvLink.text.toString())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder =
        SearchViewHolder(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val tempSearchModel = searchResultlList?.get(position)
        tempSearchModel?.let { holder.bind(it) }
    }
}