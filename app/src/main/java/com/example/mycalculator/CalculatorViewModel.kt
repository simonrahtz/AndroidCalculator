package com.example.mycalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.abs

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Clear -> state = CalculatorState()
        }

    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Subtract -> number1 - number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Divide -> number1 / number2
                null -> return
            }
            //clear screen before displaying result
            state = CalculatorState()
            state = if(result % 1.0 == 0.0){
                state.copy(
                    number1 = result.toString().dropLast(2)
                )
            } else{
                state.copy(
                    number1 = result.toString().take(15)
                )
            }
            

        }

    }

    private fun enterDecimal() {
        if (state.operation == null) {
            if (!state.number1.contains(".") && state.number1.isNotBlank()
            ) {
                state = state.copy(
                    number1 = state.number1 + "."
                )
            }
        } else if (!state.number2.contains(".") && state.number2.isNotBlank()
        ) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }

    }

    private fun enterNumber(number: Int) {
        state = if (state.operation == null) {
            state.copy(
                number1 = state.number1 + number
            )
        } else {
            state.copy(
                number2 = state.number2 + number
            )
        }


    }
}