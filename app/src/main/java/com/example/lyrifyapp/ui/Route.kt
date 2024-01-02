//package com.example.lyrifyapp.ui
//
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.NavigationBarItemDefaults
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.material3.rememberTopAppBarState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.navigation.NavDestination.Companion.hierarchy
//import androidx.navigation.NavGraph.Companion.findStartDestination
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import com.example.lyrifyapp.R
//import com.example.lyrifyapp.ui.screen.Chapter.ChapterListView
//import com.example.lyrifyapp.ui.screen.Chapter.ChapterDetailView
//import com.example.lyrifyapp.ui.screen.Gameplay.CountdownView
//import com.example.lyrifyapp.ui.screen.Gameplay.GameplayView
//import com.example.lyrifyapp.ui.screen.Gameplay.ResultView
//import com.example.lyrifyapp.ui.screen.Home.HomeView
//import com.example.lyrifyapp.ui.screen.Intro.LoginView
//import com.example.lyrifyapp.ui.screen.Register.RegisterView
//import com.example.lyrifyapp.ui.screen.Intro.Loading1View
//import com.example.lyrifyapp.ui.screen.Intro.Loading2View
//import com.example.lyrifyapp.ui.screen.Intro.Loading3View
//import com.example.lyrifyapp.ui.screen.Intro.LoadingView
//import com.example.lyrifyapp.ui.screen.Leaderboard.LeaderboardView
//import com.example.lyrifyapp.ui.theme.Orange
//import com.example.lyrifyapp.ui.theme.Purple2
//
//enum class Lyrify_Screen() {
//    Intro1,
//    Intro2,
//    Intro3,
//    Intro4,
//    Login,
//    Register,
//    Home,
//    ChapterList,
//    ChapterDetail,
//    Leaderboard,
//    Countdown,
//    Gameplay,
//    Result,
//    Profile
//}
//
//sealed class BottomNavItem(var title: String, var icon: Int, var route: String) {
//    object Home : BottomNavItem("Home", R.drawable.homepage, Lyrify_Screen.Home.name)
//    object ChapterList :
//        BottomNavItem("ChapterList", R.drawable.musical_notes, Lyrify_Screen.ChapterList.name)
//
//    object Leaderboard :
//        BottomNavItem("Leaderboard", R.drawable.leaderboard, Lyrify_Screen.Leaderboard.name)
//
//    object Profile : BottomNavItem("Profile", R.drawable.account, Lyrify_Screen.Profile.name)
//}
//
//@Composable
//fun BottomNavBarLyrify(navController: NavController) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//
//    val items = listOf(
//        BottomNavItem.Home,
//        BottomNavItem.ChapterList,
//        BottomNavItem.Leaderboard,
//        BottomNavItem.Profile
//    )
//
//    NavigationBar(
//        // https://stackoverflow.com/questions/70942583/what-is-color-of-navigationbar-in-jetpack-compose-in-material-color-scheme YAOLO KETEMU
//        containerColor = Purple2,
//        modifier = Modifier
//            .background(color = Color.Transparent)
//            .height(64.dp)
//            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
//    ) {
//        items.forEach { item ->
//            NavigationBarItem(
//                icon = {
//                    Icon(
//                        painter = painterResource(id = item.icon),
//                        contentDescription = item.title,
//                        modifier = if(item == BottomNavItem.Leaderboard) { Modifier.size(40.dp) } else { Modifier.size(32.dp) }
//                    )
//                },
//                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
//                onClick = {
//                    navController.navigate(item.route) {
//                        popUpTo(navController.graph.findStartDestination().id) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                },
//                // Customize the colors
//                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = Orange,
//                    unselectedIconColor = Color.White,
//                    selectedTextColor = Color.Transparent,
//                    indicatorColor = Purple2 // ini warna efek clickednya!
//                )
//            )
//        }
//    }
//
//}
//
//@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
//@Composable
//fun LyrifyRoute() {
//
//    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
//    val navController = rememberNavController()
//
//    val context = LocalContext.current
////    val musicViewModel = remember { MusicViewModel() }
//
////    val musicViewModel: MusicViewModel by viewModels()
//
//    var canNavigateBack by remember { mutableStateOf(false) }
//
//    Scaffold(
//        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//        bottomBar = {
//            if (canNavigateBack) {
//                BottomNavBarLyrify(navController)
//            }
//        },
//    ) { innerPadding ->
//        NavHost(
//            navController = navController,
//            startDestination = Lyrify_Screen.Home.name, // GANTI STARTNYA NYA DI SINII
//            modifier = Modifier.padding(innerPadding)
//        ) {
//
//            composable(
//                Lyrify_Screen.Intro1.name
//            ) {
//                canNavigateBack = false
//                LoadingView()
//            }
//
//            composable(Lyrify_Screen.Intro2.name) {
//                canNavigateBack = false
//                Loading1View()
//            }
//
//            composable(Lyrify_Screen.Intro3.name) {
//                canNavigateBack = false
//                Loading2View()
//            }
//
//            composable(Lyrify_Screen.Intro4.name) {
//                canNavigateBack = false
//                Loading3View()
//            }
//
////            composable(Lyrify_Screen.Login.name) {
////                canNavigateBack = true
////                LoginView()
////            }
////
////            composable(Lyrify_Screen.Register.name) {
////                canNavigateBack = true
////                RegisterView()
////            }
//
//            composable(Lyrify_Screen.Home.name) {
//                canNavigateBack = true
//                HomeView()
//            }
//
////            composable(Lyrify_Screen.Profile.name) {
////                canNavigateBack = true
////                GameplayView()
////            }
//
//            composable(Lyrify_Screen.ChapterList.name) {
//                canNavigateBack = true
//                ChapterListView()
//            }
//
//            composable(Lyrify_Screen.ChapterDetail.name) {
//                canNavigateBack = true
//                ChapterDetailView()
//            }
//
//            composable(Lyrify_Screen.Leaderboard.name) {
//                canNavigateBack = true
//                LeaderboardView()
//            }
//
//            composable(Lyrify_Screen.Countdown.name) {
//                canNavigateBack = false
//                CountdownView()
//            }
//
//            composable(Lyrify_Screen.Gameplay.name) {
//                canNavigateBack = false
//                GameplayView()
//            }
//
//            composable(Lyrify_Screen.Result.name) {
//                canNavigateBack = false
//                ResultView()
//            }
//        }
//    }
//}