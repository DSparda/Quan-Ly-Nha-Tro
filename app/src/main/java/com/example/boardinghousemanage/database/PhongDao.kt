package com.example.boardinghousemanage.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface PhongDao {

    @Insert
    fun insert(phong: Phong)

    @Update
    fun update(phong: Phong)

    @Delete
    fun delete(phong: Phong)
}