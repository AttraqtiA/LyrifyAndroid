package com.example.lyrifyapp.ui.screen.Gameplay

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlin.math.log

@Composable
fun YoutubePlayer(
    youtubeVidepId: String,
    lifecyleOwner: LifecycleOwner,
) {

    AndroidView(
        modifier = Modifier
            .alpha(0f)
            .size(0.dp),

        factory = { context ->
            YouTubePlayerView(context = context).apply {
                lifecyleOwner.lifecycle.addObserver(this)
                var count = 1

                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.loadVideo(youtubeVidepId, 0f)
                    }

                    override fun onStateChange(
                        youTubePlayer: YouTubePlayer,
                        state: PlayerConstants.PlayerState
                    ) {
                        val isEnded = state == PlayerConstants.PlayerState.ENDED
                        val isPlayingState = state == PlayerConstants.PlayerState.PLAYING
                        val isPausedState = state == PlayerConstants.PlayerState.PAUSED

                        // main 3 kali no matter what
                        if (count < 3 && isEnded) {
                            count++
                            youTubePlayer.play()
                        }
//                                buat yg isEnded ngebug kalo lg playing dipencet
//                                if (isPlayingState) {
//                                    isRestart = false
//                                }
//
//                                if (isRestart && isEnded) {
//                                    youTubePlayer.play()
//                                    isRestart = false
//                                }
                    }
                })
            }
        })
}