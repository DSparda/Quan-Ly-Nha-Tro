package com.example.boardinghousemanage.screens.rent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.boardinghousemanage.database.PhongDao

class RentViewModelFactory(private val MaPhong: Int,
                           private val database: PhongDao,
                           private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RentViewModel::class.java)) {
            return RentViewModel(MaPhong, database, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}