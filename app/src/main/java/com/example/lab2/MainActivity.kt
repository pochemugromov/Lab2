package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }
    fun getResult(view: View){
        val a =findViewById<EditText>(R.id.a)
        val b =findViewById<EditText>(R.id.b)
        val c =findViewById<EditText>(R.id.c)
        val res = findViewById<TextView>(R.id.res)
        if (a.text.toString().isNotEmpty() && b.text.toString().isNotEmpty() && c.text.toString().isNotEmpty()){
            val a = a.text.toString().toDouble()
            val b = b.text.toString().toDouble()
            val c = c.text.toString().toDouble()
            val d = b * b-4.0 * a * c
            if (a==0.0){
                if(b==0.0) {
                    if (c == 0.0) {
                        res.visibility = View.VISIBLE
                        res.text = "x - бесконечнное множество"
                    } else {
                        res.visibility = View.VISIBLE
                        res.text = "При заданных параметрах корни уравнения отсутствуют"
                    }
                }
                else {
                    val xO = -c / b
                    val result = "x = %.2f".format(xO)
                    res.visibility = View.VISIBLE
                    res.text = result
                }
            }
            else if (d>0.0){
                val xO = (-b+kotlin.math.sqrt(d))/(2*a)
                val xT = (-b-kotlin.math.sqrt(d))/(2*a)
                val result = "x1 = %.2f,\nx2 = %.2f ".format(xO,xT)
                res.visibility = View.VISIBLE
                res.text = result
            }
            else if (d == 0.0){
                val Ox= (-b)/(2*a)
                val result = "x = %.2f".format(Ox)
                res.visibility = View.VISIBLE
                res.text = result
            }
            else{
                res.visibility = View.VISIBLE
                res.text = "При заданных параметрах корни уравнения отсутствуют"
            }
        }
        else{
            Toast.makeText(this,"Заполните все поля", Toast.LENGTH_SHORT).show()
        }
    }
}