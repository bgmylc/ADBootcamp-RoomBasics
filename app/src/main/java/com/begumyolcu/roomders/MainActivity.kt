package com.begumyolcu.roomders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.begumyolcu.roomders.room.KitaplikDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var kitaplikDB: KitaplikDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kitaplikDB = KitaplikDatabase.getirKitaplikDatabase(this)!!

    }
}