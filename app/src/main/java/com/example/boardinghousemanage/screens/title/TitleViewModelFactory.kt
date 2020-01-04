package com.example.boardinghousemanage.screens.title

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.boardinghousemanage.database.PhongDao
import com.example.boardinghousemanage.screens.rent.RentViewModel

class TitleViewModelFactory(
    private val database: PhongDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TitleViewModel::class.java)) {
            return TitleViewModel(database, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}