package com.example.lyrifyapp.ui.screen.Gameplay

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lyrifyapp.R
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.Purple2
import com.example.lyrifyapp.ui.theme.Purple3
import com.example.lyrifyapp.ui.theme.Purple4
import com.example.lyrifyapp.ui.theme.montserrat

@Composable
fun GameplayView() {

    LazyColumn(
        modifier = Modifier.background(color = Background)
    ) {
        item(content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.edsheeran),
                    contentDescription = "Song Cover",
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Image(
                    painter = painterResource(id = R.drawable.blackblur),
                    contentDescription = "Black Blur",
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back",
                        modifier = Modifier.size(32.dp),
                        contentScale = ContentScale.Crop,
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp)
                        .align(Alignment.BottomCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Timer()

                    Text(
                        text = "Thinking Out Loud",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFF9100),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.96.sp,
                        )
                    )

                    Text(
                        text = "Ed Sheeran",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(600),
                            color = Purple4,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.64.sp,
                        )
                    )
                }
            }

            QuestionBox()

            Text(
                text = "Simply press the audio icon to play back the song lyrics.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(500),
                    fontStyle = FontStyle.Italic,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .background(color = Color(0xFFFF9100), shape = RoundedCornerShape(8.dp)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Check",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.8.sp,
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        })
    }


}

@Composable
fun QuestionBox() {
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 24.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFF9100), shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Fill in the blanks!",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(16.dp)
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                )
        ) {
            Row(
                Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    Modifier
                        .padding(end = 16.dp)
                        .background(
                            color = Color(0xFFFF9100),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                 ) {
                    Image(
                        painter = painterResource(id = R.drawable.speaker),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontSize = 18.sp, fontFamily = montserrat, fontWeight = FontWeight(800), color = Purple3, letterSpacing = 0.72.sp)) {
                            append("When you try your ")
                        }

                        // Apply the specified color to the "....." portion
                        withStyle(style = SpanStyle(fontSize = 18.sp, fontFamily = montserrat, fontWeight = FontWeight(800), color = Orange, letterSpacing = 0.72.sp)) {
                            append(".....")
                        }

                        withStyle(style = SpanStyle(fontSize = 18.sp, fontFamily = montserrat, fontWeight = FontWeight(800), color = Purple3, letterSpacing = 0.72.sp)) {
                            append(" , but you don't succeed")
                        }
                    }
                )
            }
        }
    }
}
@Composable
fun Timer() {
    Row(
        modifier = Modifier
            .background(color = Color(0xFF240046), shape = RoundedCornerShape(8.dp))
    ) {
        Text(
            text = "01:00",
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(700),
                color = Purple4,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameplayPreview() {
    GameplayView()
}