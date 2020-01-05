package com.example.boardinghousemanage.screens.parameter

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.boardinghousemanage.database.ThamSoDao
import com.example.boardinghousemanage.database.TroDatabase
import com.example.boardinghousemanage.screens.rent.RentViewModel

class ParameterViewModelFactory(
    val database: ThamSoDao,
    val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ParameterViewModel::class.java)) {
            return ParameterViewModel(database, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}