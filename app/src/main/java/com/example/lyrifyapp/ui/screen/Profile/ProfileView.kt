package com.example.lyrifyapp.ui.screen.Profile

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.example.lyrifyapp.R
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.LyrifyAppTheme
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.Purple2
import com.example.lyrifyapp.ui.theme.montserrat
import java.util.Calendar
import java.util.Date
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.model.User
import com.example.lyrifyapp.ui.screen.Home.HomeUIState
import com.example.lyrifyapp.ui.screen.Home.HomeViewModel
import com.example.lyrifyapp.ui.screen.LoadingErrorView
import com.example.lyrifyapp.ui.theme.grayCustom

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileView(
    profileViewModel: ProfileViewModel,
    dataStore: DataStoreManager,
    navController: NavController,
) {
    var currentUser: User? = null

    val cek_status: ProfileUIState = profileViewModel.profileUIState
    when (cek_status) {
        is ProfileUIState.Success -> {
//            currentUser = profileViewModel.userNow
        }

        is ProfileUIState.Error -> {
            LoadingErrorView()
        }

        is ProfileUIState.Loading -> {
            LoadingErrorView()
        }
    }

    var bioInput by rememberSaveable { mutableStateOf("") }


    // DATE PICKER
    // Fetching the Local Context
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    // Declaring a string value to
    // store date in string format
    val mDate = rememberSaveable { mutableStateOf("") }

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )


    // GENDER
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var gender by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Background)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(bottomStart = 70.dp, bottomEnd = 70.dp))
                            .background(color = Purple2)
                            .padding(bottom = 40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
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
                                    modifier = Modifier
                                        .size(22.dp)
                                        .clickable {
                                            //
                                        },
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    text = "Your Profile",
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
                        }
                        Box(
                            modifier = Modifier.padding(bottom = 80.dp),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.main_profile_photo),
                                contentDescription = "Profile Photo",
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(CircleShape)
                                    .clickable {
                                        //
                                    },
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(color = Orange)
                                    .size(30.dp)
                                    .clickable {
                                        //
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_edit_24),
                                    contentDescription = "Edit Profile",
                                    modifier = Modifier
                                        .size(20.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                        Text(
                            text = "${currentUser?.name}",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                                letterSpacing = 0.88.sp,
                            ),
                            modifier = Modifier.padding(top = 60.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier.padding(top = 140.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(320.dp)
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                            .background(color = Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Personal Info",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .background(color = Orange)
                                .padding(10.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            text = "Bio",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Start,
                            ),
                            modifier = Modifier
                                .background(color = Color.White)
                                .padding(start = 14.dp, end = 14.dp, top = 10.dp)
                                .fillMaxWidth()
                        )
                        TextField(
                            value = "${currentUser?.description}",
                            onValueChange = { bioInput = it },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                                textColor = Color.Black,
                                cursorColor = Orange,
                                focusedBorderColor = Color.White
                            ),
                            modifier = Modifier.fillMaxWidth()
//                    isError = IPKCalculator_UIState.checkSKSError,
                        )
                        Divider(
                            thickness = 0.1.dp,
                            color = grayCustom
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                                .padding(start = 14.dp, end = 14.dp, top = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Birthdate",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF000000),
                                    textAlign = TextAlign.Start,
                                )
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = if (mDate.value.isNotBlank()) {
                                    mDate.value
                                } else {
                                    "${currentUser?.birthdate}"
                                },
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                    textAlign = TextAlign.Start,
                                )
                            )
                            Spacer(Modifier.width(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                                contentDescription = "Calendar",
                                modifier = Modifier
                                    .size(18.dp)
                                    .clickable {
                                        mDatePickerDialog.show()
                                    },
                                contentScale = ContentScale.Crop,
                                colorFilter = ColorFilter.tint(Color.LightGray)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                                .padding(start = 14.dp, end = 14.dp, top = 7.dp, bottom = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Gender",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = montserrat,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF000000),
                                    textAlign = TextAlign.Start,
                                )
                            )
                            Spacer(Modifier.width(8.dp))
                            ExposedDropdownMenuBox(
                                expanded = isExpanded,
                                onExpandedChange = { newValue ->
                                    isExpanded = newValue
                                }
                            ) {
                                BasicTextField(
                                    value = gender.ifEmpty { "${currentUser?.gender}" },
                                    readOnly = true,
                                    onValueChange = {},
                                    textStyle = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Start,
                                    ),
                                    decorationBox = { innerTextField ->
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(0.dp),  // Set padding ke 0.dp
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Box(
                                                modifier = Modifier.weight(1f),
                                                contentAlignment = Alignment.CenterStart
                                            ) {
                                                innerTextField()
                                            }
                                            Image(
                                                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                                                contentDescription = "Arrow Down",
                                                modifier = Modifier
                                                    .size(25.dp),
                                                contentScale = ContentScale.Crop,
                                                colorFilter = ColorFilter.tint(Color.LightGray)
                                            )
                                        }
                                    },
                                    modifier = Modifier
                                        .menuAnchor()
                                        .width(80.dp)
                                )

                                ExposedDropdownMenu(
                                    expanded = isExpanded,
                                    onDismissRequest = {
                                        isExpanded = false
                                    },
                                    modifier = Modifier.background(color = Color.White)
                                ) {
                                    DropdownMenuItem(
                                        text = {
                                            Text(text = "Male")
                                        },
                                        onClick = {
                                            gender = "Male"
                                            isExpanded = false
                                        }
                                    )
                                    DropdownMenuItem(
                                        text = {
                                            Text(text = "Female")
                                        },
                                        onClick = {
                                            gender = "Female"
                                            isExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .width(320.dp)
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                            .background(color = Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Progress & Achievements",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = montserrat,
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .background(color = Orange)
                                .padding(10.dp)
                                .fillMaxWidth()
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(7.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Highest Chapter",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center
                                    )
                                )
                                Text(
                                    text = "Chapter ${currentUser?.achievement}",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center
                                    )
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(7.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Total Points",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center
                                    )
                                )
                                Text(
                                    text = "124 points on Chapter 7",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center
                                    )
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(7.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Most Played Song",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center
                                    )
                                )
                                Text(
                                    text = "Workin’ Hard - Fujii Kaze",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center
                                    )
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(7.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Most Played Artist",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center
                                    )
                                )
                                Text(
                                    text = "Fujii Kaze",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = montserrat,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ProfilePreview() {
//    LyrifyAppTheme {
//        ProfileView()
//    }
//}