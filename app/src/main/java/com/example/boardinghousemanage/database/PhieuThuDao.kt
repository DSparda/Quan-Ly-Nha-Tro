package com.example.boardinghousemanage.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhieuThuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(phieuThu: PhieuThu)

    @Query("SELECT tien_tong FROM phieu_thu_table WHERE MaPhieuThu = :key")
    fun getTong(key: Int?): LiveData<Int>
}