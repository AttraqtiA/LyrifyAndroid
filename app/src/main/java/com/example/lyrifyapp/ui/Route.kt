package com.example.lyrifyapp.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lyrifyapp.R
import com.example.lyrifyapp.ui.screen.Intro.loadingview
import com.example.lyrifyapp.ui.theme.Purple2

enum class Lyrify_Screen() {
    Intro1,
    Intro2,
    Intro3,
    Intro4,
    Login,
    SignUp,
    Home,
    ChapterList,
    ChapterDetail,
    Leaderboard,
    Music,
    ChapterComplete,
    Profile
}

sealed class BottomNavItem(var title: String, var icon: Int, var route: String) {
    object Home : BottomNavItem("Home", R.drawable.homepage, Lyrify_Screen.Home.name)
    object ChapterList :
        BottomNavItem("ChapterList", R.drawable.musical_notes, Lyrify_Screen.ChapterList.name)

    object Leaderboard :
        BottomNavItem("Leaderboard", R.drawable.leaderboard, Lyrify_Screen.Leaderboard.name)

    object Profile : BottomNavItem("Profile", R.drawable.account, Lyrify_Screen.Profile.name)
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
        containerColor = Purple2
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                // Customize the colors
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.Transparent,
                    indicatorColor = Purple2 // ini warna efek clickednya!
                )
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun LyrifyRoute() {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navController = rememberNavController()

    val context = LocalContext.current
//    val musicViewModel = remember { MusicViewModel() }

//    val musicViewModel: MusicViewModel by viewModels()

    var canNavigateBack by remember { mutableStateOf(false) }

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
            startDestination = Lyrify_Screen.Intro1.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(
                Lyrify_Screen.Intro1.name,
            ) {

                canNavigateBack = false
                loadingview()
            }


        }
    }
}