package com.practice.authflow.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practice.authflow.MainScreen
import com.practice.authflow.R


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Set up NavController for navigation within this activity
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable("login") {
                    LoginScreen(navController)
                }
                composable("main") {
                    MainScreen() // Define the composable for the main screen
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun LoginScreen(navController: NavController) {
    // Box to layer the background and other content
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.loginbg),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Column to stack the body box and button
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // Body Box (the white container with rounded corners)
            Box(
                modifier = Modifier.fillMaxWidth().size(550.dp).clip(RoundedCornerShape(10.dp))
                    .background(Color(0xffF6F6F6))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    // Text with multiple colors
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color(0xff336749))) {
                                append("Let’s ")  // First word
                            }
                            withStyle(style = SpanStyle(color = Color(0xff007A8C))) {
                                append("Travel ")  // Second word
                            }
                            withStyle(style = SpanStyle(color = Color(0xff336749))) {
                                append("you ")  // Third word
                            }
                            withStyle(style = SpanStyle(color = Color(0xff007A8C))) {
                                append("in.")  // Fourth word
                            }
                        }, fontSize = 26.sp, fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Discover the World with Every\nSign In",
                        fontSize = 21.sp,
                        color = Color(0xff336749),
                        modifier = Modifier.padding(top = 10.dp)
                    )

                    // Login Text Field
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* Handle login text change */ },
                        label = { Text("Login") },
                        placeholder = { Text("Enter your login") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp, top = 24.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF336749),
                            unfocusedBorderColor = Color(0xFF336749),
                            containerColor = Color.White,
                            focusedLabelColor = Color(0xFF336749),
                            unfocusedLabelColor = Color(0xFF336749)
                        )
                    )

                    // Password Text Field
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* Handle password text change */ },
                        label = { Text("Password") },
                        placeholder = { Text("Enter your password") },
                        shape = RoundedCornerShape(10.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                            .padding(bottom = 16.dp), // Space between fields
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF336749),
                            unfocusedBorderColor = Color(0xFF336749),
                            containerColor = Color.White,
                            focusedLabelColor = Color(0xFF336749),
                            unfocusedLabelColor = Color(0xFF336749)
                        )
                    )
                    Text(
                        text = "Forgot password?",
                        color = Color(0xFF336749),
                        modifier = Modifier.align(Alignment.End)
                    )

                    // Sign In button
                    Button(
                        onClick = {
                            // Navigate to MainScreen using NavController
                            navController.navigate("main")
                        },
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF007A8C), contentColor = Color.White
                        )
                    ) {
                        Text("Sign In")
                    }

                    Text(
                        text = "or sign in with",
                        modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)
                    )

                    HorizontalImageList()

                    Text(
                        text = "I don’t have a account?",
                        modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 35.dp)
                    )
                }
            }

            // Spacer to create space between the body box and the button
            Spacer(modifier = Modifier.height(20.dp))

            // Sign Up button
            Button(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth().height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffF6F6F6), contentColor = Color(0xff007A8C)
                )
            ) {
                Text("Sign Up")
            }
        }
    }
}

@Composable
fun HorizontalImageList() {
    // Sample image resources
    val images = listOf(
        R.drawable.google, // Replace with your actual image resources
        R.drawable.apple,
        R.drawable.facebook
    )

    // LazyRow to display items horizontally
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(images.size) { index ->
            Card(
                modifier = Modifier
                    .width(70.dp)
                    .height(40.dp)
                    .padding(end = 15.dp),
                shape = MaterialTheme.shapes.medium,
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),

                ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize().background(color = Color.White)
                ) {
                    // Image inside the box
                    Image(
                        painter = painterResource(id = images[index]),
                        contentDescription = "Image ${index + 1}",
                        modifier = Modifier.size(25.dp),
                        contentScale = ContentScale.Inside
                    )
                }
            }
        }
    }
}





