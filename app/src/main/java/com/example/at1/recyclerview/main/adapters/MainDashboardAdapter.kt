package com.example.at1.recyclerview.main.adapters

import com.example.at1.R
import com.example.at1.databinding.MainDashboardItemBinding

class MainDashboardAdapter (private val itemsList: List<String>, private val recyclerViewListner : RecyclerViewListner) : BaseAdapter<MainDashboardItemBinding, String>(itemsList){

    override val layoutId: Int = R.layout.main_dashboard_item

    override fun bind(binding: MainDashboardItemBinding, item: String) {
        binding.apply {
            listner = recyclerViewListner
            data = item
            executePendingBindings()
        }
    }
}

interface RecyclerViewListner {
    fun onItemClick(data : String)
}