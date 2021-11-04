package com.begumyolcu.roomders.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kitaplik")
data class KitapModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "kitap_Ad")
    var kitapAd: String,

    @ColumnInfo(name = "yazar_Ad")
    var yazarAd: String
)
