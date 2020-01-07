package com.example.boardinghousemanage.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface PhongDao {

    @Insert
    fun insert(phong: Phong)

    @Query("UPDATE phong_table SET so_nguoi = :nguoi, so_xe = :xe, so_tien_coc = :tienCoc WHERE MaPhong = :key")
    fun update(key: Int?, nguoi: Int, xe: Int, tienCoc: Int)

    @Query("UPDATE phong_table SET tinh_trang = :state WHERE MaPhong = :key")
    fun updateState(key: Int?, state: Int)

    @Query("DELETE FROM phong_table WHERE MaPhong= :key")
    fun delete(key: Int?)

    @Query("SELECT IFNULL (tinh_trang,0) FROM phong_table WHERE MaPhong = :key")
    fun getState(key: Int?): LiveData<Int>

    @Query("SELECT IFNULL (so_nguoi, 0) FROM phong_table WHERE MaPhong = :key")
    fun getNguoi(key: Int?): LiveData<Int>

    @Query("SELECT IFNULL (so_xe, 0) FROM phong_table WHERE MaPhong = :key")
    fun getXe(key: Int?): LiveData<Int>

    @Query("SELECT IFNULL (so_tien_coc, 0) FROM phong_table WHERE MaPhong = :key")
    fun getTienCoc(key: Int?): LiveData<Int>
}