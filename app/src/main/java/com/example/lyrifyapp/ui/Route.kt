package com.example.lyrifyapp.ui

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lyrifyapp.R
import com.example.lyrifyapp.container.MyDBContainer
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.ui.screen.Chapter.ChapterDetailView
import com.example.lyrifyapp.ui.screen.Chapter.ChapterDetailViewModel
import com.example.lyrifyapp.ui.screen.Chapter.ChapterListView
import com.example.lyrifyapp.ui.screen.Chapter.ChapterListViewModel
import com.example.lyrifyapp.ui.screen.Gameplay.CountdownView
import com.example.lyrifyapp.ui.screen.Gameplay.GameplayView
import com.example.lyrifyapp.ui.screen.Gameplay.ResultView
import com.example.lyrifyapp.ui.screen.Home.HomeView
import com.example.lyrifyapp.ui.screen.Home.HomeViewModel
import com.example.lyrifyapp.ui.screen.Intro.Loading1View
import com.example.lyrifyapp.ui.screen.Intro.Loading2View
import com.example.lyrifyapp.ui.screen.Intro.Loading3View
import com.example.lyrifyapp.ui.screen.Intro.LoadingView
import com.example.lyrifyapp.ui.screen.Intro.LoginView
import com.example.lyrifyapp.ui.screen.Leaderboard.LeaderboardView
import com.example.lyrifyapp.ui.screen.Leaderboard.LeaderboardViewModel
import com.example.lyrifyapp.ui.screen.LoadingErrorView
import com.example.lyrifyapp.ui.screen.Login.LoginViewModel
import com.example.lyrifyapp.ui.screen.Profile.ProfileView
import com.example.lyrifyapp.ui.screen.Profile.ProfileViewModel
import com.example.lyrifyapp.ui.screen.Register.RegisterView
import com.example.lyrifyapp.ui.screen.Register.RegisterViewModel
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.Purple2
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class Lyrify_Screen() {
    Intro1,
    Intro2,
    Intro3,
    Intro4,
    LoginView,
    RegisterView,
    Home,
    ChapterList,
    ChapterDetail,
    Leaderboard,
    Countdown,
    Gameplay,
    Result,
    Profile,
    LoadingView
}

sealed class BottomNavItem(var title: String, var icon: Int, var route: String) {
    object Home :
        BottomNavItem("Home", R.drawable.homepage, Lyrify_Screen.Home.name)

    object ChapterList :
        BottomNavItem("ChapterList", R.drawable.musical_notes, Lyrify_Screen.ChapterList.name)

    object Leaderboard :
        BottomNavItem("Leaderboard", R.drawable.leaderboard, Lyrify_Screen.Leaderboard.name)

    object Profile :
        BottomNavItem("Profile", R.drawable.account, Lyrify_Screen.Profile.name)
}

@Composable
fun BottomNavBarLyrify(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.ChapterList,
        BottomNavItem.Leaderboard,
        BottomNavItem.Profile
    )

    NavigationBar(
        // https://stackoverflow.com/questions/70942583/what-is-color-of-navigationbar-in-jetpack-compose-in-material-color-scheme YAOLO KETEMU
        containerColor = Purple2,
        modifier = Modifier
            .background(color = Background)
            .height(64.dp)
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = if (item == BottomNavItem.Leaderboard) {
                            Modifier.size(40.dp)
                        } else {
                            Modifier.size(32.dp)
                        }
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route)
                },
                // Customize the colors
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Orange,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.Transparent,
                    indicatorColor = Purple2 // ini warna efek clickednya!
                )
            )
        }
    }

}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun LyrifyRoute() {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navController = rememberNavController()

    //datastore
    val context = LocalContext.current
    val dataStore = DataStoreManager(context)

    GlobalScope.launch{
        dataStore.getToken.collect { token ->
            if (token != null) {
                MyDBContainer.ACCESS_TOKEN = token
            }
        }
    }
//    val musicViewModel = remember { MusicViewModel() }

//    val musicViewModel: MusicViewModel by viewModels()

    var canNavigateBack by remember { mutableStateOf(false) }

    BackHandler {
        when (navController.currentBackStackEntry?.destination?.route) {
            Lyrify_Screen.Gameplay.name -> {
                navController.popBackStack(Lyrify_Screen.ChapterDetail.name, inclusive = true)
//                navController.navigate(Lyrify_Screen.ChapterDetail.name)
            }

            else -> {
                navController.popBackStack()
            }
        }
    }


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {
            if (canNavigateBack) {
                BottomNavBarLyrify(navController)
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Lyrify_Screen.Intro1.name, // GANTI STARTNYA NYA DI SINII
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(
                Lyrify_Screen.Intro1.name
            ) {
                canNavigateBack = false
                LaunchedEffect(Unit) {
                    delay(1000L)
                    navController.navigate(Lyrify_Screen.Intro2.name)
                }
                LoadingView()
            }

            composable(Lyrify_Screen.Intro2.name) {
                canNavigateBack = false
                Loading1View { navController.navigate(Lyrify_Screen.Intro3.name) }
            }

            composable(Lyrify_Screen.Intro3.name) {
                canNavigateBack = false
                Loading2View { navController.navigate(Lyrify_Screen.Intro4.name) }
            }

            composable(Lyrify_Screen.Intro4.name) {
                canNavigateBack = false
                Loading3View { navController.navigate(Lyrify_Screen.LoginView.name) }
            }

            composable(Lyrify_Screen.LoginView.name) {
//                if (MyDBContainer.ACCESS_TOKEN == "") {
                    val loginViewModel: LoginViewModel = viewModel()
                    LoginView(
                        lvm = loginViewModel,
                        navController = navController,
                        dataStore = dataStore,
                        toRegister = { navController.navigate(Lyrify_Screen.RegisterView.name) }
                    )
                    canNavigateBack = false
//                } else {
//                    navController.navigate(Lyrify_Screen.Home.name) {
//                        popUpTo(Lyrify_Screen.LoginView.name) { inclusive = true }
//                    }
//                }
            }

            composable(Lyrify_Screen.RegisterView.name) {
                canNavigateBack = false
                val regivm: RegisterViewModel = viewModel()
                RegisterView(
                    rvm = regivm,
                    navController = navController,
                    datastore = dataStore,
                    toLogin = { navController.navigate(Lyrify_Screen.LoginView.name) }
                )
            }

            composable(Lyrify_Screen.Home.name) {
                canNavigateBack = true
                val homeViewModel: HomeViewModel = viewModel()

                HomeView(
                    homeViewModel = homeViewModel,
                    navController = navController,
                )
            }

            composable(Lyrify_Screen.Profile.name) {
                canNavigateBack = true
                val profileViewModel: ProfileViewModel = viewModel()

                ProfileView(
                    profileViewModel = profileViewModel,
                    dataStore = dataStore,
                    navController = navController,
                )
            }

            composable(Lyrify_Screen.ChapterList.name) {
                canNavigateBack = true

                val chapterListViewModel: ChapterListViewModel = viewModel()

                ChapterListView(
                    chapterListViewModel = chapterListViewModel,
                    navController = navController)
            }

            composable(Lyrify_Screen.ChapterDetail.name) {
                canNavigateBack = true

                val chapterDetailViewModel: ChapterDetailViewModel = viewModel()
                ChapterDetailView(
                    chapterDetailViewModel = chapterDetailViewModel,
                )
            }

            composable(Lyrify_Screen.Leaderboard.name) {
                canNavigateBack = true
                LeaderboardView(
                    leaderboardViewModel = LeaderboardViewModel(),
                    navController = navController,
                )
            }

            composable(Lyrify_Screen.Countdown.name) {
                canNavigateBack = false
                LaunchedEffect(Unit) {
                    delay(4030L)
                    navController.navigate(Lyrify_Screen.Gameplay.name)
                }
                CountdownView()
            }

            composable(Lyrify_Screen.Gameplay.name) {
                canNavigateBack = false
                navController.clearBackStack(Lyrify_Screen.Countdown.name)
                GameplayView(
                    navigateBack = { navController.navigateUp() },
                    toChapterDetail = { navController.navigate(Lyrify_Screen.Home.name) }
                )
            }

            composable(Lyrify_Screen.Result.name) {
                canNavigateBack = false
                ResultView()
            }

            composable(Lyrify_Screen.LoadingView.name) {
                canNavigateBack = false
                LoadingErrorView()
            }
        }
    }
}