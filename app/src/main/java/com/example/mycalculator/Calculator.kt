package com.example.mycalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.ui.theme.*


@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit

) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            //Row 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                EditResultButton(
                    operation = "AC", modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    onPress = {
                        onAction(CalculatorAction.Clear)
                    }
                )
                EditResultButton(
                    operation = "Del", modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Delete)
                    }
                )
                OperationButton(
                    operation = "/",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    })
            }
            //Row 2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                NumberButton(
                    number = "7", modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Number(7))
                    }
                )
                NumberButton(
                    number = "8", modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Number(8))
                    }
                )
                NumberButton(
                    number = "9", modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Number(9))
                    }
                )
                OperationButton(
                    operation = "x",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    })

            }
            //Row 3
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                NumberButton(
                    number = "4",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Number(4))
                    }
                )
                NumberButton(
                    number = "5",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Number(5))
                    }

                )
                NumberButton(
                    number = "6",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Number(6))
                    }
                )
                OperationButton(
                    operation = "-",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    })

            }
            //Row 4
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                NumberButton(
                    number = "1",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Number(1))
                    }
                )
                NumberButton(
                    number = "2",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Number(2))
                    }
                )
                NumberButton(
                    number = "3",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Number(3))
                    }
                )
                OperationButton(
                    operation = "+",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    })

            }
            //Row 5
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                NumberButton(
                    number = "0",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    onPress = {
                        onAction(CalculatorAction.Number(0))
                    }
                )

                OperationButton(
                    operation = ".",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(MediumGrey),
                    onPress = {
                        onAction(CalculatorAction.Decimal)
                    })
                OperationButton(
                    operation = "=",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onPress = {
                        onAction(CalculatorAction.Calculate)
                    })

            }
        }

    }
}

@Composable
fun NumberButton(
    number: String,
    modifier: Modifier = Modifier,
    onPress: () -> Unit
) {
    CalculatorButton(
        symbol = number,
        modifier = Modifier
            .background(MediumGrey)
            .then(modifier),
        onClick = onPress
    )
}

@Composable
fun OperationButton(
    operation: String,
    modifier: Modifier,
    onPress: () -> Unit

) {
    CalculatorButton(
        symbol = operation,
        modifier = Modifier
            .background(Orange)
            .then(modifier),
        onClick = onPress
    )
}

@Composable
fun EditResultButton(
    operation: String,
    modifier: Modifier,
    onPress: () -> Unit

) {
    CalculatorButton(
        textColor = Color.Black,
        symbol = operation,
        modifier = Modifier
            .background(LightGrey)
            .then(modifier),
        onClick = onPress
    )
}
