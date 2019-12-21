package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "QLPT.sqlite";
    private static final int DATABASE_VERSION=1;

    public static final String TABLE_NAME="KhachTro";

    public static final String COLUMN_MAKT="MAKT";
    public static final String COLUMN_MAPT="MAPT";
    public static final String COLUMN_HOTEN="HOTEN";
    public static final String COLUMN_GIOITINH="GIOITINH";
    public static final String COLUMN_NGHENGHIEP="NGHENGHIEP";
    public static final String COLUMN_SDT="SDT";
    public static final String COLUMN_CMND="CMND";




    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_KhachTro_table= String.format("CREATE TABLE %S(%s INTEGER PRIMARY KEY,%s TEXT,%s TEXT,%s TEXT)",
                TABLE_NAME,

                COLUMN_MAKT,
                COLUMN_MAPT,
                COLUMN_HOTEN,
                COLUMN_GIOITINH,
                COLUMN_NGHENGHIEP,
                COLUMN_SDT,
                COLUMN_CMND);
        db.execSQL(create_KhachTro_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_KhachTro_table = String.format("Drop table if exists %s",TABLE_NAME);
        db.execSQL(drop_KhachTro_table);

        onCreate(db);
    }

    //Phương thức thêm khách trọ
    public void addKhachTro(KhachTro Khach)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(COLUMN_MAKT,Khach.getMakt());
        values.put(COLUMN_MAPT,Khach.getMapt());
        values.put(COLUMN_HOTEN,Khach.getHoten());
        values.put(COLUMN_GIOITINH,Khach.getGioiTinh());
        values.put(COLUMN_NGHENGHIEP,Khach.getNgheNghiep());
        values.put(COLUMN_SDT,Khach.getSdt());
        values.put(COLUMN_CMND,Khach.getCmnd());

        db.insert(TABLE_NAME,null,values);
        db.close();

    }
    //Phương thức đọc 1 record trong bảng Khách Trọ

    public KhachTro getKhachTro(int MaKt)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.query(TABLE_NAME,null, COLUMN_MAKT + "= ?",
                new String[]{String.valueOf(MaKt)},null,null,null);

        if (cursor!=null)
        {
            cursor.moveToFirst();
        }
        KhachTro Khach = new KhachTro(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),
                cursor.getString(3),cursor.getString(4),cursor.getInt(5),
                cursor.getInt(6));
        return Khach;

    }
}
