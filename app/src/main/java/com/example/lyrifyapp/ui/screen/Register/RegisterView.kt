package com.example.lyrifyapp.ui.screen.Intro

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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lyrifyapp.ui.theme.Background
import com.example.lyrifyapp.ui.theme.Orange
import com.example.lyrifyapp.ui.theme.Purple80
import com.example.lyrifyapp.ui.theme.montserrat



@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun registerview(){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.logo),
//            contentDescription = "Lyrify",
//            contentScale = ContentScale.FillWidth,
//            modifier = Modifier.width(96.dp)
//        )
        Icon(imageVector = Icons.Filled.Person,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .padding(0.dp)
                    .width(90.dp)
                    .height(90.dp),
            tint = Orange
            )
        Text(
            text = "Create Your Account",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),

                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = "Ready to discover something new? Create  your account now to begin your journey.",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(400),
                color = Color(0xFFB6B6B6),

                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .width(255.dp)
                .height(30.dp)
        )
//        OutlinedTextField(
//            value = email,
//            onValueChange = {
//                email = it
//            },
//            modifier = Modifier
//                .padding(top = 16.dp)
//                .width(320.dp)
//                .height(64.dp),
//            shape = RoundedCornerShape(8.dp),
//
//            label = {
//                Text(
//                    text = "Email Address",
//                    style = TextStyle(
//                        fontSize = 14.sp,
//                        fontFamily = montserrat,
//                        fontWeight = FontWeight(400),
//                        color = Color(0xFFFFFFFF),
//
//                        textAlign = TextAlign.Center,
//                    ),
//                    modifier = Modifier.padding(top=2.dp),
//
//                    )
//            },
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Orange,
//                unfocusedBorderColor = Orange
//            )
//        )
        CustomTextField(value = name,
            onValueChanged = {name = it},
            text = "Name",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
        )

        CustomTextField(value = email,
            onValueChanged = {email = it},
            text = "Email Address",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
        )
        CustomTextField(value = pass,
            onValueChanged = {pass = it},
            text = "Password",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
        )
        CustomTextField(value = bio,
            onValueChanged = {bio = it},
            text = "Bio",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
        )
        OutlinedTextField(
            value = birthdate,
            onValueChange = {
                birthdate = it
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .width(320.dp)
                .height(64.dp),
            shape = RoundedCornerShape(8.dp),

            label = {
                Text(
                    text = "Birthdate",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top=2.dp),

                    )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Orange,
                unfocusedBorderColor = Orange
            ),
            trailingIcon = {
                IconButton(
                    onClick = { /**/ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Visible"
                    )

                }
            },
        )

        OutlinedTextField(
            value = gender,
            onValueChange = {
                gender = it
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .width(320.dp)
                .height(64.dp),
            shape = RoundedCornerShape(8.dp),

            label = {
                Text(
                    text = "Gender",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top=2.dp),

                    )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Orange,
                unfocusedBorderColor = Orange
            ),
            trailingIcon = {
                IconButton(
                    onClick = { /**/ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Visible"
                    )

                }
            },
        )

        Button(onClick = {/**/},
            colors = ButtonDefaults.buttonColors(containerColor = Orange),
            shape = RoundedCornerShape(7.dp),
            modifier = Modifier
                .width(320.dp)
                .height(50.dp)

        ) {
            Text(
                text = "Register",
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
            append("Already have an account? ")
            withStyle(
                style = SpanStyle(
                    color = Purple80,
                    fontWeight = FontWeight(800),
                )
            ) {
                append("Login ")
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomTextField(
    value:String,
    onValueChanged: (String) -> Unit,
    text:String,
    keyboardOptions: KeyboardOptions,
    modifier:Modifier=Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = Modifier
            .padding(top = 16.dp)
            .width(320.dp)
            .height(64.dp),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = keyboardOptions,
        label = {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),

                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(top=2.dp),

                )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Orange,
            unfocusedBorderColor = Orange
        ),

    )


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun registerpreview(){
    registerview()
}