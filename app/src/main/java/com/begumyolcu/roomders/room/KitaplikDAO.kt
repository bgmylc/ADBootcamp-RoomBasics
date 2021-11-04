package com.begumyolcu.roomders.room

import androidx.room.*

@Dao
interface KitaplikDAO {

    @Insert
    fun kitapEkle(kitap: KitapModel)

    @Update
    fun kitapGuncelle(kitap: KitapModel)

    @Delete
    fun kitapSil(kitap: KitapModel)

    @Query("SELECT * FROM kitaplik")
    fun tumKitaplar() : List<KitapModel?>
}