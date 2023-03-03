package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var mNumberDisplay: TextView? = null
    private var mExpression: SimpleExpression? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mNumberDisplay = findViewById<View>(R.id.textView1) as TextView
        mExpression = SimpleExpression()
    }

    private fun saveOperand1()
    {
        try
        {
            val value = mNumberDisplay!!.text as String
            mExpression!!.operand1 = value.toInt()
        }
        catch(e: NumberFormatException)
        {
            mExpression!!.operand1 = 0
        }
    }

    private fun saveOperand2()
    {
        try
        {
            val value = mNumberDisplay!!.text as String
            mExpression!!.operand2 = value.toInt()
        }
        catch(e: NumberFormatException)
        {
            mExpression!!.operand2 = 0
        }
    }

    fun goAC(view: View?)
    {
        mExpression!!.clearOperands()
        mNumberDisplay!!.text = "0"
    }

    fun goOperand(view: View)
    {
        val value = mNumberDisplay!!.text as String
        val digit = view.contentDescription as String

        if(value[0] == '0')
        {
            mNumberDisplay!!.text = digit
        }
        else
        {
            mNumberDisplay!!.text = (mNumberDisplay!!.text as String + digit[0])
        }
    }

    fun goOperator(view: View)
    {
        val operator = view.contentDescription as String
        if(mExpression!!.operand1 != 0)
        {
            goCompute(null)
        }
        saveOperand1()
        mNumberDisplay!!.text = "0"
        mExpression!!.operator = operator
    }
    //following code computes and displays the value
    fun goCompute(view:View?)
    {
        saveOperand2()
        mNumberDisplay!!.text = mExpression!!.value.toString()
    }
}