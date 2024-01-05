package com.example.lyrifyapp.ui.screen.Gameplay

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lyrifyapp.R
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.Orange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AnimatedCountdownTimer(
    private val coroutineScope: CoroutineScope
) {

    private val animatableScale = Animatable(1f)
    private val animatableAlpha = Animatable(1f)

    val scale: Float
        get() = animatableScale.value

    val alpha: Float
        get() = animatableAlpha.value

    fun start(initialValue: Int, endValue: Int, onChange: (Int) -> Unit) {

        var value = initialValue

        coroutineScope.launch {
            while (value > endValue - 1) {
                onChange(value)
                animatableScale.snapTo(1f)
                animatableAlpha.snapTo(1f)
                animatableScale.animateTo(2f, animationSpec = tween(750))
                animatableAlpha.animateTo(0f, animationSpec = tween(250))
                value--
            }
        }
    }
}

@SuppressLint("UnrememberedAnimatable")
@Composable
fun CountdownView() {
    val context = LocalContext.current

    var timer by remember {
        mutableStateOf(3)
    }

    val coroutineScope = rememberCoroutineScope()

    val animatedCountdownTimer = remember {
        AnimatedCountdownTimer(coroutineScope)
    }

    LaunchedEffect(Unit) {
        animatedCountdownTimer.start(3, 0) {
            timer = it
        }
        var mediaPlayer: MediaPlayer? = null
        mediaPlayer = MediaPlayer.create(context, R.raw.countdown_sound)
        mediaPlayer?.start()
    }



    Column(
        modifier = Modifier.fillMaxSize().background(color = Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.graphicsLayer {
                scaleX = animatedCountdownTimer.scale
                scaleY = animatedCountdownTimer.scale
                alpha = animatedCountdownTimer.alpha
            },
            text = if (timer == 0) { "GO!" } else { "$timer"},
            fontSize = 100.sp,
            fontWeight = FontWeight.Bold,
            color = Orange
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CountdownPreview() {
    CountdownView()
}