package com.example.boardinghousemanage.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface PhongDao {

    @Insert
    fun insert(phong: Phong)

    @Update
    fun update(phong: Phong)

    @Query ("SELECT IFNULL (tinh_trang,0) FROM phong_table WHERE MaPhong = :key")
    fun getState(key: Int?): LiveData<Int>

    @Query ("SELECT IFNULL (so_nguoi, 0) FROM phong_table WHERE MaPhong = :key")
    fun getNguoi(key: Int?): LiveData<Int>

    @Query ("SELECT IFNULL (so_xe, 0) FROM phong_table WHERE MaPhong = :key")
    fun getXe(key: Int?): LiveData<Int>

//    @Transaction
//    @Query ("SELECT * FROM phong_table WHERE MaPhong =:key")
//    fun getPhongVaPhieuthus(key: Int): List<PhieuThu>
}