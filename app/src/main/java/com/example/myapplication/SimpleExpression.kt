package com.example.myapplication

class SimpleExpression {
    var operand1 = 0
    var operand2 = 0
    var operator = "."
    private var mValue = 0
    val value:Int
    get()
    {
        computeValue()
        return mValue
    }

    /* Clears the operands within an expression */
    fun clearOperands()
    {
        operand1 = 0
        operand2 = 0
    }

    /* Computes the integer value of the expression */

    private fun computeValue()
    {
        mValue = 0
        mValue =
            if(operator.contentEquals("+"))
                operand1 + operand2
            else if (operator.contentEquals("-"))
                operand1 - operand2
            else if (operator.contentEquals("*"))
                operand1 * operand2
            else if (operator.contentEquals("/") && operand2 != 0)
                operand1 / operand2
            else operand1 % operand2

        clearOperands()
    }
}