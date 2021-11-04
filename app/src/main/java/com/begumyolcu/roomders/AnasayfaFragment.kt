package com.begumyolcu.roomders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.begumyolcu.roomders.databinding.FragmentAnasayfaBinding
import com.begumyolcu.roomders.room.KitapModel
import com.begumyolcu.roomders.room.KitaplikDatabase
import com.google.android.material.snackbar.Snackbar


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var kitaplikDB: KitaplikDatabase
    private lateinit var kitapList: List<KitapModel?>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        kitaplikDB= KitaplikDatabase.getirKitaplikDatabase(requireContext())!!

        kitapList = kitaplikDB.kitaplikDao().tumKitaplar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tumKitaplariGoster()

        binding.apply {

            buttonYeniKitap.setOnClickListener {
                findNavController().navigate(R.id.anasayfadanEklemeyeAction)
            }

            buttonGuncelle.setOnClickListener {
                kitapList = kitaplikDB.kitaplikDao().tumKitaplar()
                tumKitaplariGoster()
            }
        }
    }
    fun tumKitaplariGoster() {

        binding.apply {

            if(kitapList.isEmpty()) {
                Snackbar.make(requireView(), "Kitap Bulunamadı", 1000).show()
            } else {
                val kitaplikAdapter = KitaplikAdapter(kitapList)
                rvKitap.adapter = kitaplikAdapter
                rvKitap.layoutManager = GridLayoutManager(context, 2)
                rvKitap.setHasFixedSize(true)
            }
        }
    }

}