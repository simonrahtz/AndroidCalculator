package com.example.mycalculator

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.ui.theme.MediumGrey

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridTest() {

    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 100.dp),
        modifier = Modifier.padding(5.dp),
        content = {
            items(9) { i ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(5.dp)
                        .clip(CircleShape)
                        .background(MediumGrey),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$i",
                        fontSize = 36.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        },
    )


}

@Preview(showBackground = true)
@Composable
fun GridTestPreview() {
    GridTest()
}