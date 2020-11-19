package com.sdu.rotto_project

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.sdu.rotto_project.databinding.ActivityConstellationBinding

class ConstellationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstellationBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_constellation)

        binding.constellationDate.setOnDateChangedListener { _, _, month, day ->
            binding.constellationName.text = makeConstellationString(month, day)
        }

        binding.constellationButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("title", 1)
            with(binding.constellationDate) {
                intent.putExtra(
                    "constellation", "${this.year}년 " +
                            "${this.month}월 " +
                            "${this.dayOfMonth}일\n" +
                            "${binding.constellationName.text}"
                )
                intent.putIntegerArrayListExtra(
                    "numbers",
                    ArrayList(LottoNumberMaker.getConstellationList("${this.year}${this.month}${this.dayOfMonth}${binding.constellationName.text}"))
                )
            }
            startActivity(intent)
        }
    }

    fun makeConstellationString(month: Int, day: Int): String {

        val days = "${month + 1}${String.format("%02d", day)}".toInt()

        return when (days) {
            in 101..119 -> "염소자리"
            in 120..218 -> "물병자리"
            in 219..320 -> "물고기자리"
            in 321..419 -> "양자리"
            in 420..520 -> "황소자리"
            in 521..621 -> "쌍둥이자리"
            in 622..722 -> "게자리"
            in 723..822 -> "사자자리"
            in 823..923 -> "처녀자리"
            in 924..1022 -> "천칭자리"
            in 1023..1122 -> "전갈자리"
            in 1123..1224 -> "사수자리"
            in 1225..1231 -> "염소자리"
            else -> "나몰라"
        }
    }
}