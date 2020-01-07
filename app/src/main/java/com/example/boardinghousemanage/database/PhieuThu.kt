package com.example.boardinghousemanage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phieu_thu_table")
data class PhieuThu(
    @PrimaryKey
    var MaPhieuThu: Int,

    @ColumnInfo(name = "thang_thu")
    var ThangThu: Int,

    @ColumnInfo(name = "name_thu")
    var NamThu: Int,

    @ColumnInfo(name = "so_ki_dien")
    var TienDien: Int,

    @ColumnInfo(name = "tien_nuoc")
    var TienNuoc: Int,

    @ColumnInfo(name = "tien_phong")
    var TienPhong: Int,

    @ColumnInfo(name = "tien_xe")
    var TienXe: Int,

    @ColumnInfo(name = "tien_mang")
    var TienMang: Int,

    @ColumnInfo(name = "tien_rac")
    var TienRac: Int,

    @ColumnInfo(name = "tien_tong")
    var TienTong: Int
)