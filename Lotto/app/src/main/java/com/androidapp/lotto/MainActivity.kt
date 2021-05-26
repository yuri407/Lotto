package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

        fun getRandomLottoNumber (): Int{
            return Random.nextInt(45)+1
        }
        fun getRandomLottoNumbers (): MutableList<Int> {
            val lottoNumbers = mutableListOf<Int>()
            while (true) {
                var number: Int = getRandomLottoNumber()
                var flag_existing: Int = 0

                if(lottoNumbers.contains(number)){
                    flag_existing = 1
               //     continue;
                }
                /*for (j in 0..lottoNumbers.size) {
                    if (number.equals(lottoNumbers[j])) {
                        flag_existing = 1
                        break;
                    }
                }*/
                if (flag_existing.equals(1))
                    continue
                else
                    lottoNumbers.add(number)
                if (lottoNumbers.size >= 6)
                    break;
            }
            return lottoNumbers
        }
            /* fun getRandomLottoNumber (): Int{
            return Random.nextInt(45)+1
        }
        fun getRandomLottoNumbers (): MutableList<Int>{
            val lottoNumbers = mutableListOf<Int>()

            (1..6).forEach{
            var number = 0
            do{
            number = getRandomLottoNumber()
           }while(LottoNumbers.contains(number))
           lottoNumbers.add(number)
            }
            return lottoNumbers
             }*/


class MainActivity : AppCompatActivity() {
       override fun onCreate(savedInstanceState: Bundle?) {
             super.onCreate(savedInstanceState)
             setContentView(R.layout.activity_main)

              val cardRandom = findViewById<CardView>(R.id.cardRandom)
               cardRandom.setOnClickListener {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
                        startActivity(intent)
                    }
               val cardConstell = findViewById<CardView>(R.id.cardConstell)
               cardConstell.setOnClickListener {
                        startActivity(Intent(this, ConstellationActivity::class.java))
                    }
               val cardName = findViewById<CardView>(R.id.cardName)
               cardName.setOnClickListener {
                        startActivity(Intent(this, NameActivity::class.java))
                    }
                }
            }
