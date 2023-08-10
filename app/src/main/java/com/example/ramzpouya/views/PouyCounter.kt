package com.example.ramzpouya.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ramzpouya.R

class PouyCounter @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr : Int = 0
): LinearLayout(context,attrs,defStyleAttr) {

    var txtRes: TextView? = null

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_counter_pouya,this,true)
        val minusBtn = view.findViewById<ImageButton>(R.id.btn_minus)
        val plusBtn = view.findViewById<ImageButton>(R.id.btn_plus)
        txtRes = view.findViewById(R.id.txt_res)

        minusBtn.setOnClickListener { txtRes!!.text = (txtRes!!.text.toString().toInt() - 1).toString() }
        plusBtn.setOnClickListener { txtRes!!.text = (txtRes!!.text.toString().toInt() + 1).toString() }

    }

    fun readNumber() = run { txtRes!!.text.toString().toInt() }
    fun setNumber(num: Int){
        txtRes!!.text = num.toString()
    }

}