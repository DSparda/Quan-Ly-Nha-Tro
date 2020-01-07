package com.example.boardinghousemanage.database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface PhieuThuDao {
    @Insert
    fun insert(phieuThu: PhieuThu)
}