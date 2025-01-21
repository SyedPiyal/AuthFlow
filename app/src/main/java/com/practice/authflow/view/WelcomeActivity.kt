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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.authflow.R


class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            loadUi()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun loadUi() {
    // Box to layer the background and other content
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Centered content (Image at top center)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
        ) {
            // Image positioned at the center top
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(200.dp) // Adjust size as needed
            )
        }

        //
        // Container at the bottom with Text and Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(240.dp)
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .align(Alignment.BottomCenter)
                .background(Color.White)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(all = 20.dp)
            ) {
                // Text in the container
                Text(
                    text = "Ready to explore\nbeyond boundaries?",
                    color = Color(0xff007A8C),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(50.dp)) // Adds space between Text and Button
                // Button in the container
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff007A8C))
                ) {
                    Row {
                        Text("Your Journey Starts Here", modifier = Modifier.padding(end = 5.dp))
                        Image(
                            painter = painterResource(id = R.drawable.plain),
                            contentDescription = "plain Image",
                            modifier = Modifier.size(24.dp),
                            contentScale = ContentScale.Crop,
                        )
                    }
                }
            }
        }
    }
}



