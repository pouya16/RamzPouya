package com.example.ramzpouya.views

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
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
    var onTextChangeListener : OnTextChangeListener? = null

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_counter_pouya,this,true)
        val minusBtn = view.findViewById<ImageButton>(R.id.btn_minus)
        val plusBtn = view.findViewById<ImageButton>(R.id.btn_plus)
        txtRes = view.findViewById(R.id.txt_res)

        minusBtn.setOnClickListener { txtRes!!.text = (txtRes!!.text.toString().toInt() - 1).toString() }
        plusBtn.setOnClickListener { txtRes!!.text = (txtRes!!.text.toString().toInt() + 1).toString() }
        txtRes!!.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                try {
                    Log.d("PouyCounter", "onTextChanged: $s")
                    onTextChangeListener?.onTextChanged(s?.toString() ?: "")
                } catch (e: Exception) {
                    Log.e("PouyCounter", "Error in onTextChanged", e)
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }


    fun setOnTextChange(listener: OnTextChangeListener){
        onTextChangeListener = listener
    }

    fun readNumber() = run { txtRes!!.text.toString().toInt() }
    fun setNumber(num: Int){
        txtRes!!.text = num.toString()
    }

}