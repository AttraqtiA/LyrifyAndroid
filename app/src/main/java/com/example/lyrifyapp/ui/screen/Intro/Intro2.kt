package com.example.lyrifyapp.ui.screen.Intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontStyle
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
public fun loading1view(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
    ) {
        val text = buildAnnotatedString {
            append("\" An app that ")
            withStyle(
                style = SpanStyle(
                    color = Color(0xFFFFA500), // Orange color
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("focuses on lyrics ")
            }
            append("as a means ")
            withStyle(
                style = SpanStyle(
                    color = Color(0xFFFFA500), // Orange color
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            ) {
                append("to learn and develop skills ")
            }
            append("related to the")
            withStyle(
                style = SpanStyle(
                    color = Color(0xFFFFA500), // Orange color
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            ) {
                append(" English language.")
            }
            append("\"")
        }

        Text(
            text = text,
            style = TextStyle(
                fontSize = 26.sp,
                lineHeight = 31.2.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(800),
                fontStyle = FontStyle.Italic,
                color = Color(0xFFFFFFFF),

                letterSpacing = 1.04.sp,
            ),
            modifier = Modifier.padding(32.dp)
        )
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.asset_1),
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
                    painter = painterResource(id = R.drawable.pagination_1),
                    contentDescription = "image description",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(40.dp)
                        .height(10.dp)


                )

                Button(onClick = { /**/},
                    colors = ButtonDefaults.buttonColors(containerColor = Purple2)) {
                    Text(
                        text = "Next",
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun loadingpreview(){
    loading1view()
}