package com.sdu.rotto_project

import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

object LottoNumberMaker {
    fun getShuffleList(): MutableList<Int> {
        val list = mutableListOf<Int>()
        for (i in 1..45) { list.add(i) }
        list.shuffle()
        return list.subList(0, 6)
    }

    fun getConstellationList(days:String): MutableList<Int>{
        val list = mutableListOf<Int>()
        for (i in 1..45) { list.add(i) }
        list.shuffle(Random(days.hashCode().toLong()))
        return list.subList(0, 6)
    }

    fun getNameList(name: String): MutableList<Int>{
        val list = mutableListOf<Int>()
        for (i in 1..45) { list.add(i) }
        val seed = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name
        list.shuffle(Random(seed.hashCode().toLong()))
        return list.subList(0, 6)
    }
}