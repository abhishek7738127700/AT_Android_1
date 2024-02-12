package com.example.at1.recyclerview.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.at1.databinding.FragmentMainDashboardBinding
import com.example.at1.recyclerview.main.adapters.MainDashboardAdapter

class MainDashboardFragment : Fragment() {

    private lateinit var viewModel: MainDashboardViewModel
    private lateinit var binding: FragmentMainDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainDashboardViewModel::class.java]
        openMainDashboard()
    }

    fun openMainDashboard() {
        binding.mainDashboardAdapter = MainDashboardAdapter(viewModel.dataList)
    }

}