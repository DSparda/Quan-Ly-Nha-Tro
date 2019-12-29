package com.example.boardinghousemanage.screens.rent

import android.app.Application
import androidx.lifecycle.*
import com.example.boardinghousemanage.database.Phong
import com.example.boardinghousemanage.database.PhongDao
import kotlinx.coroutines.*

class RentViewModel(
    MaPhong: Int,
    val database: PhongDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private suspend fun insert(phong: Phong) {
        withContext(Dispatchers.IO) {
            database.insert(phong)
        }
    }

    val _songuoi = MutableLiveData<Int>()
    val _soxe = MutableLiveData<Int>()
    val _sotiencoc = MutableLiveData<Int>()

    fun onXacNhan() {
        _eventInsert.value = true
        uiScope.launch {
            val newRoom = Phong(_maPhong.value, _songuoi.value, _soxe.value, _sotiencoc.value)
            insert(newRoom)
            _navigateToTitle.value = true
        }
    }

    private val _eventInsert = MutableLiveData<Boolean>()
    val eventInsert: LiveData<Boolean>
        get() = _eventInsert

    private val _navigateToTitle = MutableLiveData<Boolean>()
    val navigateToTitle: LiveData<Boolean>
        get() =  _navigateToTitle

    private val _maPhong = MutableLiveData<Int>()
    val maPhong: LiveData<Int>
        get() = _maPhong
    val maPhongString = Transformations.map(maPhong) { key ->
        key.toString()
    }

    init {
        _maPhong.value = MaPhong
    }

    fun onEventInsertComple() {
        _eventInsert.value = false
    }

    fun onHuy() {
        _navigateToTitle.value = true
    }

    fun doneToTitle() {
        _navigateToTitle.value = false
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}