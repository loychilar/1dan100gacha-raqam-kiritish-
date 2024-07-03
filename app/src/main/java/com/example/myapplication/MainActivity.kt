package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.placeholder.MyServiceInterface
import java.util.Random

class MainActivity : AppCompatActivity(),MyServiceInterface {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    private var randomSon=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)\
        setContentView(binding.root)
        randomNumber()
        binding.btnConfirm.setOnClickListener {
            checking()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun randomNumber() {
        randomSon = Random().nextInt(100)
        binding.tvInfo.text="0 va 100 oralig'ida son yozin"
    }

    override fun counting() {
        count++
    }

    @SuppressLint("SetTextI18n")
    override fun checking() {
        counting()
        val n = binding.edtNumber.text.toString().toInt()
        if (n==randomSon){
            Toast.makeText(this, "Siz $count urinishda topdingiz", Toast.LENGTH_SHORT).show()
            binding.tvBetween.text="Siz $count urinishda topdingiz"
        }else if(n<randomSon){
            Toast.makeText(this, "Bir oz qo'shing", Toast.LENGTH_SHORT).show()
            binding.tvBetween.text="Siz kiritgan son dastur o'ylagan sondan kichik"
        }else if (n>randomSon){
            Toast.makeText(this, "Bir oz kamaytiring", Toast.LENGTH_SHORT).show()
            binding.tvBetween.text="Siz kiritgan son dastur o'ylagan katta"
        }
    }
}