package com.example.takvim

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _counter = MutableLiveData<Int>(0)
    val counter: LiveData<Int> get() = _counter

    fun incrementCounter() {
        _counter.value = (_counter.value ?: 0) + 1
    }

    fun decrementCounter() {
        _counter.value = (_counter.value ?: 0) - 1
    }

    fun resetCounter() {
        _counter.value = 0
    }
}