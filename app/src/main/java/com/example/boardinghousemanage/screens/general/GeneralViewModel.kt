package com.example.boardinghousemanage.screens.general

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.boardinghousemanage.database.PhongDao
import com.example.boardinghousemanage.database.TroDatabase

class GeneralViewModel(MaPhong: Int,
                       val database: PhongDao,
                       application: Application): AndroidViewModel(application) {
    private val _maPhong = MutableLiveData<Int>()
    val maPhong: LiveData<Int>
        get() = _maPhong


    //region Xử lí radioButton check
    private val _radioChecked = MutableLiveData<Int>()
    val radioChecked: LiveData<Int>
        get() = _radioChecked

    val layoutChecked1 = Transformations.map(radioChecked) { radio ->
        if (radio == 1)
            View.VISIBLE
        else View.GONE
    }
    val layoutChecked2 = Transformations.map(radioChecked) { radio ->
        if (radio == 2)
            View.VISIBLE
        else View.GONE
    }
    val layoutChecked3 = Transformations.map(radioChecked) { radio ->
        if (radio == 3)
            View.VISIBLE
        else View.GONE
    }

    fun radio1Checked() {
        _radioChecked.value = 1
    }

    fun radio2Checked() {
        _radioChecked.value = 2
    }

    fun radio3Checked() {
        _radioChecked.value = 3
    }
    //endregion

    init {
        _radioChecked.value = 1
        _maPhong.value = MaPhong
    }
}