package com.example.boardinghousemanage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Phong::class, ThamSo::class, PhieuThu::class], version = 1, exportSchema = false)
abstract class TroDatabase : RoomDatabase() {

    abstract val thamSoDao: ThamSoDao
    abstract val phongDao: PhongDao
    abstract val phieuThuDao: PhieuThuDao

    companion object {
        @Volatile
        private var INSTANCE: TroDatabase? = null

        fun getInstance(context: Context): TroDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TroDatabase::class.java,
                        "tro_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}