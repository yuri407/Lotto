package com.androidapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.SimpleDateFormat
import java.time.Month
import java.time.MonthDay
import java.util.*
import kotlin.collections.ArrayList

fun getShuffledLottoNumbersFromHash(str : String) : MutableList<Int>{
    val list = mutableListOf<Int>()

    for (number in 1..45) {
        list.add(number)
    }
    val targetString = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS", Locale.KOREA).format(Date()) + str
    list.shuffle(Random(targetString.hashCode().toLong()))
    return list.subList(0, 6)
}

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        Toast.makeText(applicationContext, "Constellation Activity", Toast.LENGTH_LONG).show()

        val btnGoResult = findViewById<Button>(R.id.btnGoResult)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val txtConstell = findViewById<TextView>(R.id.txtConstell)
        val calendar = Calendar.getInstance()

        txtConstell.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)

        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),
        object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener{
            override fun onSelectedDayChange(p0: CalendarView, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onDateChanged(View: DatePicker?, Year: Int, monthofYear: Int, dayofmonth: Int) {
                txtConstell.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)

            }

        })

        btnGoResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result",
                    ArrayList(getShuffledLottoNumbersFromHash(makeConstellationString(datePicker.month, datePicker.dayOfMonth))))
            intent.putExtra("Constellation", makeConstellationString(datePicker.month, datePicker.dayOfMonth))
            startActivity(intent)
        }
    }

    private fun makeConstellationString(month: Int, day: Int): String {
        val target = "${month+1}${String.format("%02d", day)}".toInt()

        when (target) {
            in 101..119 -> return "염소자리"
            in 120..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭소자리"
            in 1023..1122 -> return "전갈자리"
            in 1123..1224 -> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else -> return "기타별자리"
        }
    }
}
