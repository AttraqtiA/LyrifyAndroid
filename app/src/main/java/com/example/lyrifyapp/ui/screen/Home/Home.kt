package com.example.lyrifyapp.ui.screen.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lyrifyapp.R
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.ChapColor
import com.example.lyrifyapp.ui.theme.ChapDesc
import com.example.lyrifyapp.ui.theme.Green
import com.example.lyrifyapp.ui.theme.LyrifyAppTheme
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.montserrat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(homeViewModel: HomeViewModel = viewModel()) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = {
            LazyColumn(
                contentPadding = PaddingValues(top = 30.dp, bottom = 30.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Background)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.main_profile_photo),
                            contentDescription = "profile_photo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(70.dp)
                                .height(70.dp)
                                .clip(CircleShape)
                        )
                        Spacer(Modifier.width(12.dp))
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Hi Louis!",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),
                                    letterSpacing = 0.88.sp,
                                )
                            )
                            Spacer(Modifier.height(2.dp))
                            Text(
                                text = "As always “Let the melody be your guide to linguistic proficiency!\"",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFB6B6B6),
                                )
                            )
                        }
                    }
                }
                item {
                    Spacer(Modifier.height(25.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Last Song",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                                letterSpacing = 0.56.sp,
                            ),
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                }
                item {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        item {
                            SongCard()
                        }
                        item {
                            SongCard()
                        }
                        item {
                            SongCard()
                        }
                    }
                }
                item {
                    Spacer(Modifier.height(25.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Completed Chapter",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                                letterSpacing = 0.56.sp,
                                textAlign = TextAlign.Start
                            )
                        )
                        Text(
                            text = "See All",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight(500),
                                color = Orange,
                                textAlign = TextAlign.Right,
                                letterSpacing = 0.48.sp,
                            )
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                }
                item {
                    ChapterCard()
                }
                item {
                    ChapterCard()
                }
                item {
                    ChapterCard()
                }
            }
        }
    )
}

@Composable
fun SongCard(

) {
    Card(
        shape = RoundedCornerShape(7.dp),
        border = BorderStroke(0.5.dp, Orange),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = ChapColor,
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.artistpicture),
                    contentDescription = "artist_picture_1",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(7.dp))
                )
                Spacer(Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Cruel Summer",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(800),
                            color = ChapDesc,
                            letterSpacing = 0.48.sp,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(Modifier.height(1.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Taylor Swift",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(600),
                            color = Orange,
                            letterSpacing = 0.4.sp,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(Modifier.height(1.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "2019",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.32.sp,
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
                    .size(24.dp)
                    .clickable {
                        //
                    }
            )
        }
    }
}

@Composable
fun ChapterCard(

) {
    Card(
        shape = RoundedCornerShape(7.dp),
        border = BorderStroke(0.5.dp, Orange),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = ChapColor,
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 10.dp, bottom = 14.dp, end = 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Chapter 1",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(800),
                            color = ChapDesc,
                            letterSpacing = 0.64.sp,
                            textAlign = TextAlign.Start
                        ),
                    )
                }
                Spacer(Modifier.height(3.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "“Exploring the Tapestry of Music”",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.48.sp,
                            textAlign = TextAlign.Start
                        )
                    )
                }
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        buildAnnotatedString {
                            append("Total point: ")
                            withStyle(
                                style = SpanStyle(
                                    color = Green
                                )
                            ) {
                                append("100 points")
                            }
                        },
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.32.sp,
                            textAlign = TextAlign.Start
                        )
                    )
                }
                Spacer(Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Button(
                        onClick = {
                            //
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Orange,
                            contentColor = Color(0xFFFFFFFF)
                        ),
                        shape = RoundedCornerShape(7.dp),
                        modifier = Modifier
                            .width(78.dp)
                            .height(30.dp),
                        contentPadding = PaddingValues(
                            start = 8.dp,
                            end = 4.dp,
                            top = 4.dp,
                            bottom = 7.dp
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Open",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFFFFFFFF),
                                    letterSpacing = 0.56.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_play_arrow_24),
                                contentDescription = "Play Arrow",
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(top = 2.dp)
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chapter_1),
                    contentDescription = "Chapter_1",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    LyrifyAppTheme {
        HomeView()
    }
}