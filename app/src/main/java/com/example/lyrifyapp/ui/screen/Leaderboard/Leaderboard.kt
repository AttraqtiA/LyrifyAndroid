package com.example.lyrifyapp.ui.screen.Leaderboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.lyrifyapp.R
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.Purple2
import com.example.lyrifyapp.ui.theme.montserrat

@Composable
fun LeaderboardView(
    leaderboardViewModel: LeaderboardViewModel = viewModel()

) {
    val variabel_UIState by leaderboardViewModel.uiState.collectAsState()

    Column (
        Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Purple2)
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
            Text(
                text = "Leaderboard",
                style = TextStyle(
                    fontSize = 20.sp,
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
                    .size(32.dp),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.Transparent)
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item(content = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Purple2,
                            shape = RoundedCornerShape(bottomStart = 48.dp, bottomEnd = 48.dp)
                        )
                        .padding(top = 8.dp, bottom = 32.dp, start = 32.dp, end = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Top3Card(
                        2, Modifier
                            .size(width = 100.dp, height = 150.dp)
                            .background(
                                brush = Brush.linearGradient(listOf(Color(0xFF70706F), Color(0xFFBEC0C2))),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .offset(y = 12.dp)
                    )
                    Top3Card(
                        1, Modifier
                            .size(width = 100.dp, height = 160.dp)
                            .background(
                                brush = Brush.linearGradient(listOf(Color(0xFFB78628), Color(0xFFFCC201))),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .offset(y = 12.dp), Modifier.padding(top = 8.dp)
                    )
                    Top3Card(
                        3, Modifier
                            .size(width = 100.dp, height = 150.dp)
                            .background(
                                brush = Brush.linearGradient(listOf(Color(0xFF804A00), Color(0xFFB08D57))),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .offset(y = 12.dp)
                    )
                }
            })

            itemsIndexed(variabel_UIState.ListUser) { index, user: User ->
                RankingBar(index + 4)
            }

            item(content = {
                Spacer(modifier = Modifier.height(4.dp))

                RankingBar(4)
                RankingBar(5)
                RankingBar(6)
                RankingBar(7)
                RankingBar(8)
                RankingBar(9)
                RankingBar(10)
                RankingBar(11)
                RankingBar(12)
            })

        }
    }

}

@Composable
fun Top3Card(Placement: Int, modifierBox: Modifier = Modifier, modifierText: Modifier = Modifier) {
    Box(
        modifier = modifierBox
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)

        ) {
            AsyncImage(
                model = null, // ImageRequest.Builder(LocalContext.current).data(selectedImage).crossfade(true).build()
                placeholder = painterResource(id = R.drawable.louis),
                contentDescription = "Muka Bagus",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .clickable {

                    },
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Louis Fernando",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 12.6.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF3C096C),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.56.sp,
                ),
                modifier = modifierText
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(28.dp)
                .background(color = Background, shape = CircleShape),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${Placement}",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 12.6.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(700),
                    color = Orange,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.56.sp,
                )
            )
        }

    }
}

@Composable
fun RankingBar(Placement: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "${Placement}",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 14.4.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF10002B),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.64.sp,
                )
            )

            AsyncImage(
                model = null, // ImageRequest.Builder(LocalContext.current).data(selectedImage).crossfade(true).build()
                placeholder = painterResource(id = R.drawable.jonah),
                contentDescription = "Muka Bagus",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .clickable {

                    },
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = "Oliver Hayes",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF10002B),
                )
            )
        }

        Text(
            text = "212 points",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(500),
                color = Color(0xFFFF9100),
            )
        )
    }

    Divider(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .height(1.dp)
    )

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LeaderboardPreview() {
    LeaderboardView()
}