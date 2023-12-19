package com.example.at1.recyclerview.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.at1.databinding.MainDashboardItemBinding
import com.example.at1.recyclerview.main.model.DataModel

internal class MainDashboardAdapter(private val itemsList: List<DataModel>) :
    RecyclerView.Adapter<MainDashboardAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(private val itemViewBinding: MainDashboardItemBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(data: DataModel) {
            itemViewBinding.data = data
        }
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemViewBinding = MainDashboardItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size
}