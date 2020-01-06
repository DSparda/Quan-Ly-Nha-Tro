package com.example.boardinghousemanage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tham_so")
data class ThamSo (
    @PrimaryKey
    var MaSo: Int,

    @ColumnInfo(name = "don_gia_ki_dien")
    var DonGiaKiDien: Int,

    @ColumnInfo(name = "don_gia_nuoc")
    var DonGiaNuoc: Int,

    @ColumnInfo(name = "don_gia_phong")
    var DonGiaPhong: Int,

    @ColumnInfo(name = "don_gia_xe")
    var DonGiaXe: Int,

    @ColumnInfo(name = "don_gia_mang")
    var DonGiaMang: Int,

    @ColumnInfo(name = "don_gia_rac")
    var DonGiaRac: Int
)