package com.example.kws_cekilis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.kws_cekilis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var participantList = mutableListOf<Participant>()
    var winnerParticipant = Participant("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tbul.setOnClickListener{ talihlibul() }
        binding.tekle.setOnClickListener{ addParticipantToList() }
    }

    fun addParticipantToList() {

        var isimString = binding.isimgir.text.toString()
        var dscString = binding.dscgir.text.toString()

        if (TextUtils.isEmpty(isimString) || TextUtils.isEmpty(dscString)) {
            binding.bilgi.text = "Lürfen bilgi gir."
        }
        else {
            val participant = Participant(isimString,dscString)
            participantList.add(participant)
            binding.bilgi.text = "${participant.isim} added to list."
        }
        binding.isimgir.text.clear()
        binding.dscgir.text.clear()

    }

    fun talihlibul() {
        if (participantList.count() == 0) {
            binding.bilgi.text = "Talihli ekle."
        }
        else {
            winnerParticipant = participantList.random()
            binding.ktalihli.text = winnerParticipant.isim
            binding.kdsc.text = winnerParticipant.dsc
        }
    }

}

class Participant(val isim : String, val dsc : String) {  }
