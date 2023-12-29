package com.example.lyrifyapp.ui.screen.Gameplay

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lyrifyapp.ui.theme.Background
import kotlinx.coroutines.delay

@SuppressLint("UnrememberedAnimatable")
@Composable
fun CountdownView() {
    var countdownState by remember { mutableIntStateOf(3) }
    val animatable = Animatable(countdownState.toFloat())

    LaunchedEffect(Unit) {
        while (countdownState > 0) {
            countdownState--
            animatable.animateTo(countdownState.toFloat(), animationSpec = tween(750))
            delay(1000L) // Adjust delay between numbers
        }
        animatable.animateTo(0f) // Animate to "GO!"
        countdownState = -1 // Indicate countdown finished
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .background(color = Background)
    ) {
        Text(
            text = when (countdownState) {
                3, 2, 1 -> "$countdownState"
                -1 -> "GO!"
                else -> ""
            },
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White,
        )

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CountdownPreview() {
    CountdownView()
}