package com.androidapp.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result") // ?: return
        /*if (result == null) {
            return
        }
        println("result is $result")
        result.sort()
        println("result sorted is $result") */

        val result_sorted = result?.sortedBy { it }
//        println("result_sorted is" + result_sorted)
        // val result_sorted = result?.Let {result.sortedBy{it}}
        //result?.Let {
        // updateLottoBallImages(result.sortedBy{it}}
   // }
        val lottoBallImageStartID = R.drawable.ball_01
/*        val lottoBallImageID2 = R.drawable.ball_02
        val lottoBallImageID3 = R.drawable.ball_03*/
        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)

        imageView1.setImageResource(lottoBallImageStartID + result_sorted!![0] - 1)
        imageView2.setImageResource(lottoBallImageStartID + result_sorted[1] - 1)
        imageView3.setImageResource(lottoBallImageStartID + result_sorted[2] - 1)
        imageView4.setImageResource(lottoBallImageStartID + result_sorted[3] - 1)
        imageView5.setImageResource(lottoBallImageStartID + result_sorted[4] - 1)
        imageView6.setImageResource(lottoBallImageStartID + result_sorted[5] - 1)

    }
   // private fun updateLottoBallImages(result_sorted : ArrayList<int>) {
  /* private fun updateLottoBallImages(result_sorted : List<int>) {

    }*/
}