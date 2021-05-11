package com.example.myagetominutes

import android.R.attr.y
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {view->
            ClickDatePicker(view)
//            Toast.makeText(this,"Button Works", Toast.LENGTH_LONG).show()
        }

    }
    fun ClickDatePicker(view: View)
    {
        val mycalander = Calendar.getInstance()
        val year = mycalander.get(Calendar.YEAR)
        val month = mycalander.get(Calendar.MONTH)
        val day = mycalander.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->
                  val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                ageid.setText(selectedDate)

                val sdf =SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                val SelectedDateToMinutes = theDate!!.time/60000
                val CurrentDate= sdf.parse(sdf.format(System.currentTimeMillis()))
                val CurrentDateToMinutes=CurrentDate!!.time/60000
                val result = CurrentDateToMinutes-SelectedDateToMinutes
                ageisthis.setText(result.toString())


            }
            ,year
            ,month
            ,day)
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }
}
