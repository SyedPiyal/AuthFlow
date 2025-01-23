package com.practice.authflow.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.authflow.R


class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            splashScreen()
        }
        // Delay for 2 seconds and navigate to LoginActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Start the LoginActivity after the delay
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // Finish SplashActivity so the user can't return to it
            finish()
        }, 2000)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun splashScreen() {
    // Background color blue
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff007A8C))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Welcome Image",
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.Center)
            )
        }
    }
}


