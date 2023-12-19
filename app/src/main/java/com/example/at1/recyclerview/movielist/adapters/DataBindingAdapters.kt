package com.example.at1.recyclerview.movielist.adapters

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.at1.R
import com.google.android.material.imageview.ShapeableImageView

private val TAG = "DataBindingAdapter"

@BindingAdapter("setAdapter")
fun setAdapter(recyclerView: RecyclerView, adapter: BaseAdapter<ViewDataBinding, ListAdapterItem>?) {
    Log.d(TAG, "DataBindingAdapter :: setAdapter :: ")
    adapter?.let {
        recyclerView.adapter = it
    }
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("submitList")
fun submitList(recyclerView: RecyclerView, list: List<ListAdapterItem>?) {
    Log.d(TAG, "DataBindingAdapter :: submitList :: ")
    val adapter = recyclerView.adapter as BaseAdapter<ViewDataBinding, ListAdapterItem>?
    adapter?.updateData(list ?: listOf())
}

@BindingAdapter("manageState")
fun manageState(progressBar: ProgressBar, state: Boolean) {
    Log.d(TAG, "DataBindingAdapter :: manageState :: state : $state")
    progressBar.visibility = if (state) View.VISIBLE else View.GONE
}

@BindingAdapter("setImage")
fun setImage(imageView: ShapeableImageView, image: Int) {
    Log.d(TAG, "DataBindingAdapter :: setImage :: ")
    Glide.with(imageView.context)
        .load(image)
        .into(imageView)
}

@BindingAdapter("setFavouriteCondition")
fun setFavouriteCondition(imageView: ShapeableImageView, isFavourite: Boolean) {
    Log.d(TAG, "DataBindingAdapter :: setFavouriteCondition :: ")
    if (isFavourite) {
        imageView.setImageResource(R.drawable.ic_favorite)
    } else {
        imageView.setImageResource(R.drawable.ic_favorite_border)
    }

}
