package com.example.boardinghousemanage.screens.title

import android.view.View
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel: ViewModel() {
    private val _eventButton = MutableLiveData<Boolean>()
    val eventButton: LiveData<Boolean>
        get() = _eventButton

    private val _maPhong = MutableLiveData<Int>()
    val maPhong: LiveData<Int>
        get() = _maPhong

    fun onEventButton(v: View) {
        var b: Button = v as Button
        _maPhong.value = b.text.toString().toInt()
        _eventButton.value = true
    }

    fun onEventButtonComple() {
        _eventButton.value = false
    }
}