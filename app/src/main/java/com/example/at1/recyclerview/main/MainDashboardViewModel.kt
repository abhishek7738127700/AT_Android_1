package com.example.at1.recyclerview.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.at1.recyclerview.main.adapters.RecyclerViewListner
import com.example.at1.recyclerview.main.dashboarddata.DashBoardItems
import kotlinx.coroutines.launch

class MainDashboardViewModel : ViewModel(), RecyclerViewListner {

    private var TAG = "MainDashboardViewModel"

    private val _dashBoardItemList = MutableLiveData<List<String>>()
    val dashBoardItemList: LiveData<List<String>> = _dashBoardItemList

    init {
        setDashboardItem()
    }

    private fun setDashboardItem()
    {
        viewModelScope.launch {
            _dashBoardItemList.value = DashBoardItems.dataList
        }
    }

    override fun onItemClick(data: String) {
        Log.i(TAG, "MainDashboardViewModel :: onItemClick :: $data")
    }
}