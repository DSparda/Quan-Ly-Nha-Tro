package com.example.boardinghousemanage.screens.parameter

import android.app.Application
import android.view.View
import android.widget.Button
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.boardinghousemanage.database.ThamSo
import com.example.boardinghousemanage.database.ThamSoDao
import kotlinx.coroutines.*

class ParameterViewModel(
    val database: ThamSoDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _check = MutableLiveData<Int>()
    val check: LiveData<Int>
        get() = _check

    fun doneToNavigating() {
        _check.value = -1
    }

    val _sodien = MutableLiveData<Int>()
    val _sonuoc = MutableLiveData<Int>()
    val _sophong = MutableLiveData<Int>()
    val _soxe = MutableLiveData<Int>()
    val _sonet = MutableLiveData<Int>()
    val _sorac = MutableLiveData<Int>()
    val state = database.getState(1)

    fun mapTag(p: Int): Int =
        when (p) {
            0 -> 0
            else -> 1
        }

    fun onXacNhan(v: View) {
        uiScope.launch {
//            _eventInsert.value = true
            val newParameter = ThamSo(
                1,
                DonGiaKiDien = _sodien.value!!,
                DonGiaNuoc = _sonuoc.value!!,
                DonGiaPhong = _sophong.value!!,
                DonGiaXe = _soxe.value!!,
                DonGiaMang = _sonet.value!!,
                DonGiaRac = _sorac.value!!
            )
            insert(newParameter)
            val b: Button = v as Button
            when (b.tag) {
                0 -> _check.value = 0
                1 -> _check.value = 1
            }
        }
    }

    private suspend fun insert(thamSo: ThamSo) {
        withContext(Dispatchers.IO) {
            database.insert(thamSo)
        }
    }

    fun onHuy(v: View) {
        val b: Button = v as Button
        when (b.tag) {
            0 -> _check.value = 0
            1 -> _check.value = 1
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}