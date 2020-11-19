package com.sdu.rotto_project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sdu.rotto_project.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    val lottoImageStartId = R.drawable.ball_01

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)

        when (intent.getIntExtra("title", 0)) {
            1 -> {
                binding.title.text = "${intent.getStringExtra("constellation")}로 생성된"
            }
            2 -> {
                binding.title.text = "${intent.getStringExtra("name")}님의 이름으로 생성된"
            }
            else -> {
                binding.title.text = "랜덤으로 생성된"
            }
        }

        val list = intent.getIntegerArrayListExtra("numbers")

        list?.let { setResource(list.sortedBy { it }) }

    }

    fun setResource(list: List<Int>) {
        if (list.size < 6) return
        binding.randomBall1.setImageResource(lottoImageStartId + (list[0] - 1))
        binding.randomBall2.setImageResource(lottoImageStartId + (list[1] - 1))
        binding.randomBall3.setImageResource(lottoImageStartId + (list[2] - 1))
        binding.randomBall4.setImageResource(lottoImageStartId + (list[3] - 1))
        binding.randomBall5.setImageResource(lottoImageStartId + (list[4] - 1))
        binding.randomBall6.setImageResource(lottoImageStartId + (list[5] - 1))
    }
}