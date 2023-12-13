package com.example.lyrifyapp.ui.screen.Gameplay

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lyrifyapp.R
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.montserrat

@Composable
fun ResultView() {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
            .padding(top = 24.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item(content = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF240046), shape = RoundedCornerShape(16.dp))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.chapter_2),
                    contentDescription = "image description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                )

                Text(
                    text = "Chapter 2",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(800),
                        color = Color(0xFFFF9100),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.96.sp,
                    )
                )

                Text(
                    text = "“Unveiling the Essence of Music”",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFC77DFF),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.72.sp,
                    )
                )
            }
            
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))

            Text(
                text = "Excellent!",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Italic,
                    color = Color(0xFFFF9100),
                    textAlign = TextAlign.Center,
                    letterSpacing = 1.12.sp,
                )
            )

            Text(
                text = "You have completed the whole chapter!",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.56.sp,
                )
            )

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SummaryBox("Total Points", "100")
                SummaryBox("Spent Time", "10:12")
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SummaryBox("Longest", "Believer")
                SummaryBox("Fastest", "Fix You")
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(24.dp))

            Button(
                onClick = {
                    /* TODO */
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .background(color = Color(0xFFFF9100), shape = RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(Orange)
            ) {
                Text(
                    text = "Done",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.8.sp,
                    ),
                )
            }

        })
    }
}

@Composable
fun SummaryBox(title: String, content: String) {
    Column(
        Modifier.width(130.dp)

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(color = Orange, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (title == "Total Points") {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(32.dp)
                        .padding(end = 8.dp)
                )
            } else if (title == "Spent Time") {
                Image(
                    painter = painterResource(id = R.drawable.timer),
                    contentDescription = "icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(32.dp)
                        .padding(end = 8.dp)
                )
            }

            Text(
                text = content,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(800),
                    color = Orange,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ResultPreview() {
    ResultView()
}
