package com.example.lyrifyapp.ui.screen.Home

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lyrifyapp.R
import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.Chapter
import com.example.lyrifyapp.model.Music
import com.example.lyrifyapp.model.UserAPIResponse
import com.example.lyrifyapp.ui.Lyrify_Screen
import com.example.lyrifyapp.ui.screen.LoadingErrorView
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.ChapColor
import com.example.lyrifyapp.ui.theme.ChapDesc
import com.example.lyrifyapp.ui.theme.GreenCorrect
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.montserrat
import retrofit2.Response
import kotlin.random.Random

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    homeViewModel: HomeViewModel,
    navController: NavController,
) {
    val cek_status: HomeUIState = homeViewModel.homeUIState

    var userId: Int? = null
    var userNow: Response<UserAPIResponse>? = null
    var musicList: Response<APIListResponse<List<Music>>>? = null
    var chapterList: Response<APIListResponse<List<Chapter>>>? = null

    val context = LocalContext.current
    when (cek_status) {
        is HomeUIState.Success -> {
            userId = cek_status.user
            userNow = cek_status.userNow
            musicList = cek_status.musicList
            chapterList = cek_status.chapterList
        }

        is HomeUIState.Error -> {
            LoadingErrorView()
        }

        is HomeUIState.Loading -> {
            LoadingErrorView()
        }

    }

    val musics: APIListResponse<List<Music>>? = musicList?.body()
    val chapters: APIListResponse<List<Chapter>>? = chapterList?.body()

    var selectedImage by rememberSaveable { mutableStateOf<Uri?>(null) }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) {
        selectedImage = it
    }

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
                        if (userNow?.body()?.data?.image == "profile_default.png") {
                            AsyncImage(
                                model = "https://lyrify.online/resources/local_assets/profile_default.png",
                                placeholder = painterResource(id = R.drawable.profilepicture),
                                contentDescription = "Profile Picture",
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(70.dp)
                                    .clip(CircleShape)
                            )
                        } else {
                            AsyncImage(
                                model = ImageRequest.Builder(context = LocalContext.current)
                                    .data("${userNow?.body()?.data?.image}")
                                    .crossfade(true)
                                    .build(),
                                placeholder = painterResource(id = R.drawable.profilepicture),
                                contentDescription = "Profile Picture",
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(70.dp)
                                    .clip(CircleShape)
                            )
                        }
                        Spacer(Modifier.width(12.dp))
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = if (userNow?.body()?.data?.name == null) {
                                    "Hi --loading--!"
                                } else {
                                    "Hi ${userNow.body()?.data?.name}!"
                                },
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
                            text = "Songs Just For You",
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
//                        val random = Random(System.currentTimeMillis()) // Seed with current time
//                        val randomFiveMusic = musicList.shuffled(random)?.distinctBy { it.title }.take(5)


//                        musics?.data?.size?.let { it1 ->
//                            items(it1) { index ->
//                                SongCard(
//                                    image = musics.data[index].image,
//                                    title = musics.data[index].title,
//                                    artist = musics.data[index].artist,
//                                    year_released = musics.data[index].artist,
//                                    navController = navController
//                                )
//                            }
//                        }

                        item {
                            SongCard(
                                image = "fix_you.jpg",
                                title = "Fix You",
                                artist = "Coldplay",
                                year_released = "2008",
                                navController = navController
                            )
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
                            text = "Recommended Chapter",
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

                Toast.makeText(context, musics.toString(), Toast.LENGTH_LONG).show()

                chapters?.data?.size?.let { it1 ->
                    items(it1) { index ->
                        ChapterCard(
                            count = index + 1,
                            image = chapters.data[index].image,
                            title = chapters.data[index].title,
                            navController = navController
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun SongCard(
    image: String,
    title: String,
    artist: String,
    year_released: String,
    navController: NavController
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(0.5.dp, Orange),
        modifier = Modifier.fillMaxWidth()
            .clickable(onClick = {
                navController.navigate(Lyrify_Screen.Countdown.name)
            }),
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
                AsyncImage(
                    model = "https://lyrify.online/resources/local_assets/${image}",
                    contentDescription = "Music Cover Album",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(10.dp))
                )


                Spacer(Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = title,
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
                        text = artist,
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
                        text = year_released,
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
    count: Int,
    image: String,
    title: String,
    navController: NavController
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(0.5.dp, Orange),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            .clickable(onClick = {
                navController.navigate(Lyrify_Screen.Countdown.name)
            }),
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
                        text = "Chapter $count",
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
                        text = title,
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
                                    color = GreenCorrect
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
                AsyncImage(
                    model = "https://lyrify.online/resources/local_assets/${image}",
                    contentDescription = "Chapter Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomePreview() {
//    LyrifyAppTheme {
//        HomeView()
//    }
//}