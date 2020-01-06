package com.example.boardinghousemanage.screens.rent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.boardinghousemanage.database.PhongDao
import com.example.boardinghousemanage.database.ThamSoDao
import com.example.boardinghousemanage.screens.general.GeneralViewModel

class GeneralViewModelFactory(
    private val MaPhong: Int,
    private val databasePhong: PhongDao,
    private val databaseThamSo: ThamSoDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GeneralViewModel::class.java)) {
            return GeneralViewModel(MaPhong, databasePhong, databaseThamSo, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}