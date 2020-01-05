package com.example.boardinghousemanage.screens.parameter

import android.app.Application
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

    private val _navigateToTitle = MutableLiveData<Boolean>()
    val navigateToTitle: LiveData<Boolean>
        get() = _navigateToTitle

    fun doneToTitle() {
        _navigateToTitle.value = false
    }

    val _sodien = MutableLiveData<Int>()
    val _sonuoc = MutableLiveData<Int>()
    val _sophong = MutableLiveData<Int>()
    val _soxe = MutableLiveData<Int>()
    val _sonet = MutableLiveData<Int>()
    val _sorac = MutableLiveData<Int>()

    fun onXacNhan() {
        uiScope.launch {
//            _eventInsert.value = true
            val newParameter = ThamSo(
                DonGiaKiDien = _sodien.value!!,
                DonGiaNuoc = _sonuoc.value!!,
                DonGiaPhong = _sophong.value!!,
                DonGiaXe = _soxe.value!!,
                DonGiaMang = _sonet.value!!,
                DonGiaRac = _sorac.value!!
            )
            insert(newParameter)
            _navigateToTitle.value = true
        }
    }

    private suspend fun insert(thamSo: ThamSo) {
        withContext(Dispatchers.IO) {
            database.insert(thamSo)
        }
    }

    fun onHuy() {
        _navigateToTitle.value = true
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}