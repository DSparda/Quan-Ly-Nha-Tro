package com.example.boardinghousemanage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phong_table")
data class Phong (
    @PrimaryKey
    var MaPhong: Int,

    @ColumnInfo(name = "so_nguoi")
    var SoNguoi:Int,

    @ColumnInfo(name = "so_xe")
    var SoXe: Int,

    @ColumnInfo(name = "so_tien_coc")
    var SoTienCoc: Int,

    @ColumnInfo(name = "tinh_trang")
    var TinhTrang: Int
)
