package com.example.boardinghousemanage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phong_table")
data class Phong (
    @PrimaryKey(autoGenerate = true)
    var MaPhong: Long = 0L,

    @ColumnInfo(name = "so_nguoi")
    var SoNguoi:Long,

    @ColumnInfo(name = "so_xe")
    var SoXe: Long,

    @ColumnInfo(name = "so_tien_coc")
    var SoTienCoc: Long
)