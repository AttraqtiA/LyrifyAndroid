package com.example.lyrifyapp.ui.screen.Intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lyrifyapp.R
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.Purple2
import com.example.lyrifyapp.ui.theme.montserrat

@Composable
fun Loading3View(ButtonClicked: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        val text = buildAnnotatedString {
            append("Elevate your ")
            withStyle(
                style = SpanStyle(
                    color = Color(0xFFFFA500), // Orange color
                    fontWeight = FontWeight(800),
                )
            ) {
                append("English Listening ")
            }
            append("skills.")

        }

        Text(
            text = text,
            style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 31.2.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(800),
                color = Color(0xFFFFFFFF),

                letterSpacing = 2.sp,
            ),
            modifier = Modifier.padding(top = 32.dp, end = 32.dp, start= 32.dp)
        )
        Text(
            text = "Training your ears to grasp the nuances of every lyric and refine your proficiency in English.",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),

                ),
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.asset_3),
                contentDescription = "Listener",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
//                    .fillMaxWidth()
                    .size(600.dp)
            )
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 24.dp)
                    .height(64.dp)
            ){

                Image(
                    painter = painterResource(id = R.drawable.pagination_3),
                    contentDescription = "image description",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(40.dp)
                        .height(10.dp)
                )

                Button(onClick = ButtonClicked,
                    colors = ButtonDefaults.buttonColors(containerColor = Purple2)) {
                    Text(
                        text = "Getting Started",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(800),
                            color = Color(0xFFFFFFFF),

                            textAlign = TextAlign.Center,
                        )
                    )
                }

            }

        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun loading3preview(){
//    Loading3View()
//}