package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import kotlin.random.Random

fun getRandomLottoNumber () : Int{
    return Random(getRandomLottoNumber()).nextInt(45)+1
}
fun getRandomLottoNumbers () : MutableList<Int> {
    val lottoNumbers = mutableListOf<Int>()

    while (true) {
        var number: Int = getRandomLottoNumber()

        if(lottoNumbers.contains(number)) {
            continue
        }
        lottoNumbers.add(number)
        if(lottoNumbers.size >= 6)
            break
    }
    return lottoNumbers
}
fun getShuffledLottoNumbers () : MutableList<Int> {
    val list = mutableListOf<Int>()

    for (number in 1..45){
        list.add(number)
    }
    list.shuffle()

    return  list.subList(0, 6)

}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CardView1 = findViewById<CardView>(R.id.CardView1)
        CardView1.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }

        val CardView2 = findViewById<CardView>(R.id.CardView2)
        CardView2.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }

        val CardView3 = findViewById<CardView>(R.id.CardView3)
        CardView3.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffledLottoNumbers()))
            startActivity(intent)
        }
    }
}
