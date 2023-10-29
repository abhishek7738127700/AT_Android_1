package com.example.at1.uicomponent

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    private var TAG = "FirstViewModel"
    var name = MutableLiveData("Abhishek 0")
    private var counter = 0

    fun changeName() {
        counter++
        Log.d(TAG, "counter: $counter")

        if (counter == 1) {
            name.value = "Abhishek 1"
        } else if (counter == 2) {
            name.value = "Abhishek 2"
        }
    }
}