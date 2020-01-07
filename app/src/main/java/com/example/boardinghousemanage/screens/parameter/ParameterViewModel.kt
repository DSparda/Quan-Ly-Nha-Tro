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
    val _state = MutableLiveData<Int>()

    fun onXacNhan() {
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
            when (_state.value) {
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

    fun onHuy() {
        when (_state.value) {
            0 -> _check.value = 0
            1 -> _check.value = 1
        }
    }

    var check1 = false
    var check2 = false
    var check3 = false
    var check4 = false
    var check5 = false
    var check6 = false

    fun check(c1: Boolean, c2: Boolean, c3: Boolean, c4: Boolean, c5: Boolean, c6: Boolean): Boolean {
        if (c1 == true && c2 == true && c3 == true && c4 == true && c5 == true && c6 == true)
            return true
        return false
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}