package com.org.userstory101.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.org.userstory101.ui.theme.GreenA
import com.org.userstory101.ui.theme.RedA


@Composable
fun Chart(
    data: List<Triple<Float, Float, String>>,
    max_value: Int,
    modifier: Modifier = Modifier,
    delivered: Boolean = true,
    pending: Boolean = true
) {
    val context = LocalContext.current
    // BarGraph Dimensions
    val barGraphHeight by remember { mutableStateOf(200.dp) }
    val barGraphWidth by remember { mutableStateOf(60.dp) }
    // Scale Dimensions
    val scaleYAxisWidth by remember { mutableStateOf(50.dp) }
    val scaleLineWidth by remember { mutableStateOf(2.dp) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(barGraphHeight),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            // scale Y-Axis
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(scaleYAxisWidth),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = max_value.toString())
                    Spacer(modifier = Modifier.fillMaxHeight(0.80f))
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = (max_value - 2000).toString())
                    Spacer(modifier = Modifier.fillMaxHeight(0.64f))
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = (max_value - 4000).toString())
                    Spacer(modifier = Modifier.fillMaxHeight(0.48f))
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = (max_value - 5000).toString())
                    Spacer(modifier = Modifier.fillMaxHeight(0.32f))
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = (max_value - 5500).toString())
                    Spacer(modifier = Modifier.fillMaxHeight(0.16f))
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = (0).toString())
                    Spacer(modifier = Modifier.fillMaxHeight(0f))
                }

            }
            // Y-Axis Line
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(scaleLineWidth)
                    .background(Color.Black)
            )
            // graph
            data.forEach() {
                Row {
                    Spacer(modifier = modifier.padding(start = barGraphWidth))
                    if (delivered) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.Bottom)
                                .width(barGraphWidth)
                                .fillMaxHeight(it.first)
                                .background(GreenA)
                                .clickable {
                                }
                        )
                    }
                    if (pending) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.Bottom)
                                .width(barGraphWidth)
                                .fillMaxHeight(it.second)
                                .background(RedA)
                                .clickable {
                                }
                        )
                    }
                }
            }

        }
        // X-Axis Line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(scaleLineWidth)
                .background(Color.Black)
        )
        // Scale X-Axis
        Row(
            modifier = Modifier
                .padding(start = scaleYAxisWidth + barGraphWidth + scaleLineWidth)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(barGraphWidth)
        ) {

            data.forEach {
                Text(
                    modifier = Modifier.width(barGraphWidth),
                    text = it.third,
                    textAlign = TextAlign.Center
                )
            }

        }

    }
}

val data = listOf(
    Triple(0.5f, 0.2f, "Jan"),
    Triple(0.6f, 0.3f, "Feb"),
    Triple(0.2f, 0.5f, "Mar"),
    Triple(0.7f, 0.4f, "Apr"),
    Triple(0.8f, 0.6f, "May"),

    )

val max_value = 6000

@Preview(showSystemUi = true)
@Composable
private fun ChartType() {
    Chart(data = data, max_value = max_value)
}