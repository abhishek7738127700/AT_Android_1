package com.example.at1.recyclerview.main

import androidx.lifecycle.ViewModel
import com.example.at1.recyclerview.main.dashboarddata.DashBoardItems

class MainDashboardViewModel : ViewModel() {
    val dataList = DashBoardItems.dataList;
}