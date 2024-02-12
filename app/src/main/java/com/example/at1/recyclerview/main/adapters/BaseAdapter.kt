package com.example.at1.recyclerview.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.at1.recyclerview.movielist.viewholder.BaseViewHolder

abstract class BaseAdapter<viewDataBinding : ViewDataBinding, T : String>(var data : List<T>) : RecyclerView.Adapter<BaseViewHolder<viewDataBinding>>(){

    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun bind(binding: viewDataBinding, item: T)

    fun updateData(list: List<T>) {
        this.data = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<viewDataBinding> {
        val binder = DataBindingUtil.inflate<viewDataBinding>(LayoutInflater.from(parent.context), layoutId, parent, false)
        return BaseViewHolder(binder)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<viewDataBinding>, position: Int) {
        bind(holder.binder, data[position])
    }

    override fun getItemCount(): Int = data.size
}