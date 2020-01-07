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

    val _songuoi = MutableLiveData<Int>()
    val _soxe = MutableLiveData<Int>()
    val _sotiencoc = MutableLiveData<Int>()

    private val _maPhong = MutableLiveData<Int>()
    val maPhong: LiveData<Int>
        get() = _maPhong
    val maPhongString = Transformations.map(maPhong) { key ->
        key.toString()
    }

    private val _navigateToTitle = MutableLiveData<Boolean>()
    val navigateToTitle: LiveData<Boolean>
        get() = _navigateToTitle

    init {
        _maPhong.value = MaPhong
    }

    fun onXacNhan() {
        uiScope.launch {
            val newRoom =
                Phong(_maPhong.value!!, _songuoi.value!!, _soxe.value!!, _sotiencoc.value!!, 1)
            insert(newRoom)
            _navigateToTitle.value = true
        }

    }

    private suspend fun insert(phong: Phong) {
        withContext(Dispatchers.IO) {
            database.insert(phong)
        }
    }

    fun onHuy() {
        _navigateToTitle.value = true
    }

    fun doneToTitle() {
        _navigateToTitle.value = false
    }

    var check1 = false
    var check2 = false
    var check3 = false

    fun check(c1: Boolean, c2: Boolean, c3:Boolean):Boolean {
        if (c1 == true && c2 == true && c3 == true)
            return true
        return false
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}