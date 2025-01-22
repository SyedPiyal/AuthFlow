package com.practice.authflow.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.authflow.R
import com.practice.authflow.utils.TicketShapeVertically

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {

    Box() {
        Image(
            painter = painterResource(id = R.drawable.home_top),
            contentDescription = "Logo Image",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth() // Adjust size as needed
        )
        Column(modifier = Modifier.padding(16.dp)) {
            AppBar()
            // search
            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle login text change */ },
                label = { Text("Where To go?") },
                placeholder = { Text("Where To go?") },
                shape = RoundedCornerShape(10.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search), // Replace with your search icon
                        contentDescription = "Search Icon"
                    )
                },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp, top = 24.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF336749),
                    unfocusedBorderColor = Color(0xFF336749),
                    containerColor = Color.White,
                    focusedLabelColor = Color(0xFF336749),
                    unfocusedLabelColor = Color(0xFF336749)
                )
            )

            //tickets
            CustomTicket()
        }
    }
}

@Composable
fun AppBar() {
// App bar
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left side: Text "Hi, User" and coin image with "2000 points"
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hi, User",
                style = MaterialTheme.typography.headlineSmall.copy(color = Color.White)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_coin), // Replace with your coin icon resource
                    contentDescription = "Coin Icon",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "2000 points",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color(0xffFFC107))
                )
            }
        }

        // Right side: Image with round shape
        Image(
            painter = painterResource(id = R.drawable.ic_profile), // Replace with your profile image
            contentDescription = "User Profile",
            modifier = Modifier
                .size(50.dp) // Round shape size
                .clip(CircleShape) // Make image circular
                .border(2.dp, Color.Gray, CircleShape) // Optional border around the profile image
        )
    }
}

@Composable
fun CustomTicket() {
    val shapeCustom = TicketShapeVertically(
        16.dp,
        CornerSize(15.dp)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(
                color = Color.White,
                shapeCustom
            )
            .clip(
                shapeCustom
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(
                    10.dp,
                )
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Image(
                painter = painterResource(id = R.drawable.ic_profile), // Replace with your profile image
                contentDescription = "User Profile",
                modifier = Modifier
                    .size(50.dp) // Round shape size
                    .clip(CircleShape) // Make image circular
                    .border(
                        2.dp,
                        Color.Gray,
                        CircleShape
                    ) // Optional border around the profile image
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Success")
            Spacer(modifier = Modifier.height(110.dp))
//            DottedLineCuston()
            HorizontalDivider(
                modifier = Modifier.padding(bottom = 30.dp, start = 10.dp, end = 10.dp),
                color = Color(0xFF336749),
                thickness = 0.06.dp
            )
            Row (modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Booking ID",
                    color = Color(0xFF336749),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "ZEEBAW",
                    color = Color(0xFF336749),
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}

@Composable
fun DottedLineCuston() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    Canvas(Modifier.fillMaxWidth().height(1.dp)) {
        drawLine(
            color = Color.Red,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}
