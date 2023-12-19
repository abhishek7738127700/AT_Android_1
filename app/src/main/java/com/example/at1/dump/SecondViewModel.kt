package com.example.at1.dump

import android.util.Log
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    private val TAG = "SecondViewModel"

    fun checkOnClick() {
        Log.d(TAG, "SecondViewModel :: checkOnClick: ")
    }

}