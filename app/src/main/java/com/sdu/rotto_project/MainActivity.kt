package com.sdu.rotto_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sdu.rotto_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.mainRanNumber.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            intent.putIntegerArrayListExtra("numbers",ArrayList(LottoNumberMaker.getShuffleList()))
            startActivity(intent)
        }

        binding.mainConstellationMake.setOnClickListener { startActivity(Intent(this, ConstellationActivity::class.java)) }

        binding.mainNameNumber.setOnClickListener { startActivity(Intent(this, NameActivity::class.java)) }

    }
}