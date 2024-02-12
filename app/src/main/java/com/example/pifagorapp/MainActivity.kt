package com.example.pifagorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    fun onClickCompute(view: View){
        if (!isFieldEmpty()) bindingClass.TextResult.text = getResult()
    }

    private fun isFieldEmpty(): Boolean{
        bindingClass.apply {
            if (edTextA.text.isNullOrEmpty()) edTextA.error = "Fields are blank!"
            if (edTextB.text.isNullOrEmpty()) edTextB.error = "Fields are blank!"
            return edTextA.text.isNullOrEmpty() || edTextB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String{
        val a: Double
        val b: Double
        bindingClass.apply {
            a = edTextA.text.toString().toDouble()
            b = edTextB.text.toString().toDouble()
        }
        return sqrt((a.pow(2) + b.pow(2))).toString()
    }



}