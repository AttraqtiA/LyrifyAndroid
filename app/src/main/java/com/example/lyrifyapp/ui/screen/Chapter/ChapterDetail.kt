package com.example.lyrifyapp.ui.screen.Chapter

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lyrifyapp.R
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.LyrifyAppTheme
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.Purple2
import com.example.lyrifyapp.ui.theme.montserrat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterDetailView(chapterdetailViewModel: ChapterDetailViewModel = viewModel()) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Background),
                contentPadding = PaddingValues(bottom = 10.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.chapter),
                                    contentDescription = "Back",
                                    modifier = Modifier.fillMaxWidth(),
                                    contentScale = ContentScale.FillWidth
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 20.dp, horizontal = 15.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                                        contentDescription = "Back",
                                        modifier = Modifier
                                            .size(22.dp)
                                            .clickable {
                                                //
                                            },
                                        contentScale = ContentScale.Crop,
                                    )
                                }
                            }
                            Image(
                                painter = painterResource(id = R.drawable.black_blur),
                                contentDescription = "black_blur",
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillWidth,
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Chapter 1",
                                style = TextStyle(
                                    fontSize = 26.sp,
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFF9100),
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.96.sp,
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Text(
                                text = "“Exploring the Tapestry of Music”",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF9D4EDD),
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 0.64.sp,
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
                item {
                    ChapterDetailCard()
                }
                item {
                    ChapterDetailCard()
                }
                item {
                    ChapterDetailCard()
                }
                item {
                    ChapterDetailCard()
                }
                item {
                    ChapterDetailCard()
                }
            }
        }
    )
}

@Composable
fun ChapterDetailCard(

) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Purple2,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "1",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(800),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Start,
                            letterSpacing = 0.72.sp,
                        ),
                        modifier = Modifier
                            .background(Orange)
                            .padding(horizontal = 17.dp, vertical = 15.dp)
                    )
                    Spacer(Modifier.width(10.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Believer",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                                letterSpacing = 0.72.sp,
                                textAlign = TextAlign.Start
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "by Imagine Dragons",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF),
                                letterSpacing = 0.4.sp,
                                textAlign = TextAlign.Start
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.playbutton),
                    contentDescription = "play_button",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {
                            //
                        }
                )
            }
            Image(
                painter = painterResource(id = R.drawable.song),
                contentDescription = "song",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(110.dp),
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChapterDetailPreview() {
    LyrifyAppTheme {
        ChapterDetailView()
    }
}