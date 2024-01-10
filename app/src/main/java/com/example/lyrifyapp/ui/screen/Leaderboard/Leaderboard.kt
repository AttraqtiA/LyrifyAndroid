
package com.example.lyrifyapp.ui.screen.Leaderboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.lyrifyapp.R
import com.example.lyrifyapp.model.APIListResponse
import com.example.lyrifyapp.model.History
import com.example.lyrifyapp.model.HistoryAPIResponse
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.model.UserAPIResponse
import com.example.lyrifyapp.ui.screen.Home.ChapterCard
import com.example.lyrifyapp.ui.screen.LoadingErrorView
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.Purple2
import com.example.lyrifyapp.ui.theme.montserrat
import retrofit2.Response


data class UserHistory(val userId: Int, var points: Int)

// Create a dummy list of UserHistory with base points 2000
val dummyHistory: List<UserHistory> = List(10) { index ->
    UserHistory(userId = index + 1, points = 2000)
}

@Composable
fun NormalCard(user: User, navController: NavController) {
    val index = 3
    ChapterCard(
        count = index + 1,  // Assuming count starts from 4 for normal cards
        image = user.image ?: "", // Use an empty string if image is null
        title = user.name ?: "",   // Use an empty string if name is null
        navController = navController
    )
}

//@Composable
//fun Top3Card(Placement: Int, modifierBox: Modifier = Modifier, modifierText: Modifier = Modifier, user: User) {
//    Box(
//        modifier = modifierBox
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(4.dp)
//
//        ) {
//            AsyncImage(
//                model = user.image, // Use the image parameter
//                placeholder = painterResource(id = R.drawable.louis),
//                contentDescription = "Muka Bagus",
//                modifier = Modifier
//                    .size(80.dp)
//                    .clip(CircleShape)
//                    .clickable {
//
//                    },
//                contentScale = ContentScale.Crop
//            )
//            Text(
//                text = user.name,
//                style = TextStyle(
//                    fontSize = 14.sp,
//                    lineHeight = 12.6.sp,
//                    fontFamily = montserrat,
//                    fontWeight = FontWeight(700),
//                    color = Color(0xFF3C096C),
//                    textAlign = TextAlign.Center,
//                    letterSpacing = 0.56.sp,
//                ),
//                modifier = modifierText
//            )
//        }
//
//        Row(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .size(28.dp)
//                .background(color = Background, shape = CircleShape),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "${Placement}",
//                style = TextStyle(
//                    fontSize = 14.sp,
//                    lineHeight = 12.6.sp,
//                    fontFamily = montserrat,
//                    fontWeight = FontWeight(700),
//                    color = Orange,
//                    textAlign = TextAlign.Center,
//                    letterSpacing = 0.56.sp,
//                )
//            )
//        }
//
//    }
//}

@Composable
fun RankingBar(Placement: Int, user: User) {
    var points = 2000
    val deduction = 100 // Points to deduct

    // Find the corresponding UserHistory in the dummy list
    val userHistory = dummyHistory.find { it.userId == it.points}

    // Deduct points if UserHistory is found
    userHistory?.let {
        if (it.points >= deduction) {
            it.points -= deduction
            points = it.points
        } else {
            points = 0
        }
    }

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
                model = user.image, // Use the image parameter
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
                text = user.name,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF10002B),
                )
            )
        }

        Text(
            text = "$points points", // Display the updated points
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(500),
                color = Color(0xFFFF9100),
            )
        )
    }
}


@Composable
fun LeaderboardView(
    leaderboardViewModel: LeaderboardViewModel,
    navController: NavController,
) {
    val cek_status: LeaderboardUIState = leaderboardViewModel.leaderboardUIState
//    val cek_status by leaderboardViewModel.leaderboardUIState.collectAsState()

    var userId: Int? = null
    var userNow: Response<UserAPIResponse>? = null
    var userList: Response<APIListResponse<List<User>>>? = null
    var histories: Response<HistoryAPIResponse>? = null

    val context = LocalContext.current
    when (cek_status) {
        is LeaderboardUIState.Success -> {
            userId = cek_status.user
            userNow = cek_status.userNow
            userList = cek_status.userList
            histories = cek_status.histories
        }

        is LeaderboardUIState.Error -> {
            LoadingErrorView()
        }

        is LeaderboardUIState.Loading -> {
            LoadingErrorView()
        }

    }
    val user: APIListResponse<List<User>>? = userList?.body()
    val history: HistoryAPIResponse? = histories?.body()

    val topUsers = user?.data?.take(12) ?: emptyList()

    Column(
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
                val userList = user?.data ?: emptyList()
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
//                    Top3Card(
//                        2, Modifier
//                            .size(width = 100.dp, height = 150.dp)
//                            .background(
//                                brush = Brush.linearGradient(
//                                    listOf(
//                                        Color(0xFF70706F),
//                                        Color(0xFFBEC0C2)
//                                    )
//                                ),
//                                shape = RoundedCornerShape(16.dp)
//                            )
//                            .offset(y = 12.dp)
//                    )
//                    Top3Card(
//                        1, Modifier
//                            .size(width = 100.dp, height = 160.dp)
//                            .background(
//                                brush = Brush.linearGradient(
//                                    listOf(
//                                        Color(0xFFB78628),
//                                        Color(0xFFFCC201)
//                                    )
//                                ),
//                                shape = RoundedCornerShape(16.dp)
//                            )
//                            .offset(y = 12.dp), Modifier.padding(top = 8.dp)
//                    )
//                    Top3Card(
//                        3, Modifier
//                            .size(width = 100.dp, height = 150.dp)
//                            .background(
//                                brush = Brush.linearGradient(
//                                    listOf(
//                                        Color(0xFF804A00),
//                                        Color(0xFFB08D57)
//                                    )
//                                ),
//                                shape = RoundedCornerShape(16.dp)
//                            )
//                            .offset(y = 12.dp)
//                    )
                }
            })

//            for (index in 0 until 3) {
//                item(content = {
//                    Top3Card(index + 1, Modifier.size(width = 100.dp, height = 150.dp))
//                })
//            }


            itemsIndexed(topUsers) { index, user ->
                if (index >= 0) {
                    // User 4 and above
                    RankingBar(index + 1, user)
                }
            }
//            itemsIndexed(user?.data ?: emptyList()) { index, user ->
//                if (index >= 3) {
//                    // User 4 and above
//                    val userHistory = history?.data?.find { it.userId == user.id } // Adjust the condition based on your data structure
//                    RankingBar(user, userHistory)
//                }
//            }
        }

    }
}
            @Preview(showSystemUi = true, showBackground = true)
            @Composable
            fun LeaderboardPreview() {
                val navController = rememberNavController()
                LeaderboardView(
                    leaderboardViewModel = LeaderboardViewModel(),
                    navController = navController
                )
            }