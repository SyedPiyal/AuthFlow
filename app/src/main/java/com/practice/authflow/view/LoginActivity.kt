package com.practice.authflow.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.practice.authflow.R
import com.practice.authflow.view.ui.theme.AuthFlowTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            loginView()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun loginView() {
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
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // Body Box (the white container with rounded corners)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(400.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
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
                        },
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp), // Space between fields
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF336749), // Border color when focused
                            unfocusedBorderColor = Color(0xFF336749), // Border color when unfocused
                            containerColor = Color.White, // Background color of the text field
                            focusedLabelColor = Color(0xFF336749), // Label color when focused
                            unfocusedLabelColor = Color(0xFF336749) // Label color when unfocused
                        )
                    )

                    // Password Text Field
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* Handle password text change */ },
                        label = { Text("Password") },
                        placeholder = { Text("Enter your password") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp), // Space between fields
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF336749),
                            unfocusedBorderColor = Color(0xFF336749),
                            containerColor = Color.White,
                            focusedLabelColor = Color(0xFF336749),
                            unfocusedLabelColor = Color(0xFF336749)
                        )
                    )

                }
            }

            // Spacer to create space between the body box and the button
            Spacer(modifier = Modifier.height(20.dp))

            // Sign Up button
            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xff007A8C)
                )
            ) {
                Text("Sign Up", modifier = Modifier.padding(end = 5.dp))
            }
        }
    }
}


