package com.example.boardinghousemanage.screens.rent

import android.app.Application
import androidx.lifecycle.*
import com.example.boardinghousemanage.database.PhongDao

class RentViewModel(MaPhong: Int,
                    val database: PhongDao,
                    application: Application) : AndroidViewModel(application) {

    private val _eventButton = MutableLiveData<Boolean>()
    val eventButton: LiveData<Boolean>
        get() = _eventButton

    private val _maPhong = MutableLiveData<Int>()
    val maPhong: LiveData<Int>
        get() = _maPhong
    val maPhongString = Transformations.map(maPhong) { key ->
        key.toString()
    }

    init {
        _maPhong.value = MaPhong
    }

    fun onEventButton() {
        _eventButton.value = true
    }

    fun onEventButtonComple() {
        _eventButton.value = false
    }
}