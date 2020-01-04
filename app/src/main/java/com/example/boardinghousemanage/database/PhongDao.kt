package com.example.boardinghousemanage.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PhongDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(phong: Phong)

    @Update
    fun update(phong: Phong)

    @Query ("SELECT IFNULL (tinh_trang,0) FROM phong_table WHERE MaPhong = :key")
    fun getState(key: Int?): LiveData<Int>
}