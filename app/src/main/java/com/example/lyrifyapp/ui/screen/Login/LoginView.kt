package com.example.lyrifyapp.ui.screen.Intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lyrifyapp.R
import com.example.lyrifyapp.data.DataStoreManager
import com.example.lyrifyapp.ui.screen.Login.LoginViewModel
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.Purple80
import com.example.lyrifyapp.ui.theme.montserrat


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(
    lvm: LoginViewModel,
    navController: NavController,
    dataStore:DataStoreManager
) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    val context = LocalContext.current

    var passwordVisibility by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Lyrify",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.width(96.dp)
        )
        Text(
            text = "Welcome Back",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),

                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = "Enter your credentials and continue your journey with us.",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(400),
                color = Color(0xFFB6B6B6),

                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .width(195.dp)
                .height(30.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(top = 16.dp)
                .width(320.dp)
                .height(64.dp),
            shape = RoundedCornerShape(8.dp),

            label = {
                Text(
                    text = "Email Address",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top = 2.dp),

                    )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Orange,
                unfocusedBorderColor = Orange
            )
        )
        OutlinedTextField(
            value = pass,
            onValueChange = {
                pass = it
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .width(320.dp)
                .height(64.dp),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            label = {
                Text(
                    text = "Password",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top = 2.dp),

                    )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Orange,
                unfocusedBorderColor = Orange
            ),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        imageVector = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Toggle password visibility",
                        tint = Color.White
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),

            )

        Button(
            onClick = {
                lvm.loginbutton(
                    email = email,
                    password = pass,
                    context=context,
                    dataStore=dataStore
                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = Orange),
            shape = RoundedCornerShape(7.dp),
            modifier = Modifier
                .width(320.dp)
                .height(50.dp),
            enabled = email.isNotBlank() && pass.isNotBlank()

        ) {
            Text(
                text = "Login",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),

                    textAlign = TextAlign.Center,
                ),
            )


        }
        val text = buildAnnotatedString {
            append("Didn't have an account? ")
            withStyle(
                style = SpanStyle(
                    color = Purple80,
                    fontWeight = FontWeight(800),
                )
            ) {
                append("Register ")
            }

        }

        Text(
            text = text,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(400),
                color = Color(0xFFB6B6B6),

                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun loginpreview(){
//    loginview()
//}