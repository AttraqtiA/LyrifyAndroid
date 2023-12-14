package com.example.lyrifyapp.ui.screen.Chapter

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.lyrifyapp.ui.theme.DarkPurple
import com.example.lyrifyapp.ui.theme.Green
import com.example.lyrifyapp.ui.theme.LyrifyAppTheme
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.montserrat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterListView(chapterlistViewModel: ChapterListViewModel = viewModel()) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Background)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back",
                        modifier = Modifier.size(22.dp),
                        contentScale = ContentScale.Crop,
                    )
                    Text(
                        text = "Chapter List",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.8.sp,
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(22.dp),
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(Color.Transparent)
                    )
                }
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFFFFF)
                    ),
                ) {
                    Text(
                        text = "Choose your chapter",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.64.sp,
                        ),
                        modifier = Modifier
                            .background(Orange)
                            .padding(10.dp)
                            .fillMaxWidth()
                    )
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxWidth(),
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(15.dp),
                        horizontalArrangement = Arrangement.spacedBy(7.dp),
                        verticalArrangement = Arrangement.spacedBy(7.dp)
                    ) {
                        item {
                            ChapterListCard()
                        }
                        item {
                            ChapterListCard()
                        }
                        item {
                            ChapterListCard()
                        }
                        item {
                            ChapterListCard()
                        }
                        item {
                            ChapterListCard()
                        }
                        item {
                            ChapterListCard()
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ChapterListCard(

) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(0.5.dp, Orange),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = DarkPurple,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.chapter_1),
                contentDescription = "artist_picture_1",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(Modifier.height(5.dp))
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
                        color = Color(0xFFFF9100),
                        letterSpacing = 0.64.sp,
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
                    text = "“Exploring the Tapestry of Music”",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFC77DFF),
                        letterSpacing = 0.4.sp,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(Modifier.height(7.dp))
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
                            append("0 points")
                        }
                    },
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.32.sp,
                        textAlign = TextAlign.Start
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChapterListPreview() {
    LyrifyAppTheme {
        ChapterListView()
    }
}