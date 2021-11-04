package com.begumyolcu.roomders.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [KitapModel::class], version = 1)
abstract class KitaplikDatabase : RoomDatabase() {

    abstract fun kitaplikDao(): KitaplikDAO

    companion object {

        private var INSTANCE: KitaplikDatabase? = null

        fun getirKitaplikDatabase(context: Context): KitaplikDatabase? {

            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    KitaplikDatabase::class.java,
                    "kitaplik.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

    }
}