package com.androidapp.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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

        val result_sorted = result?.sortedBy{it}
        println("result_sorted is" + result_sorted)
    }
}