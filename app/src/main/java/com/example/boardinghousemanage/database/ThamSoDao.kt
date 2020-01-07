package com.example.boardinghousemanage.database

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ThamSoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(thamSo: ThamSo)

    @Query("SELECT IFNULL (don_gia_ki_dien, 0) FROM tham_so")
    fun getDien(): LiveData<Int>

    @Query("SELECT IFNULL (don_gia_nuoc, 0) FROM tham_so")
    fun getNuoc(): LiveData<Int>

    @Query("SELECT IFNULL (don_gia_phong, 0) FROM tham_so")
    fun getPhong(): LiveData<Int>

    @Query("SELECT IFNULL (don_gia_xe, 0) FROM tham_so")
    fun getXe(): LiveData<Int>

    @Query("SELECT IFNULL (don_gia_mang, 0) FROM tham_so")
    fun getMang(): LiveData<Int>

    @Query("SELECT IFNULL (don_gia_rac, 0) FROM tham_so")
    fun getRac(): LiveData<Int>
}
