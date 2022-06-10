package com.example.taskgooglesearch.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.taskgooglesearch.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {
    private lateinit var binding: FragmentWebViewBinding
    private lateinit var  searchWebView: WebView

    val args: WebViewFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchWebView = binding.webView
        searchWebView.loadUrl(args.webSiteLink)
    }
}