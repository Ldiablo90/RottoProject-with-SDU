package com.sdu.rotto_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sdu.rotto_project.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_name)

        binding.nameBtn1.setOnClickListener {
            if (TextUtils.isEmpty(binding.nameEdit.text.toString())){
                Toast.makeText(applicationContext, "이름을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("title",2)
            intent.putExtra("name",binding.nameEdit.text.toString())
            intent.putIntegerArrayListExtra("numbers", ArrayList(LottoNumberMaker.getNameList(binding.nameEdit.text.toString())))
            startActivity(intent)
        }

        binding.nameBtn2.setOnClickListener { finish() }


    }
}