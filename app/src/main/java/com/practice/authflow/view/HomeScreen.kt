package com.practice.authflow.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.authflow.R
import com.practice.authflow.dataModel.Item
import com.practice.authflow.dataModel.ItemData
import com.practice.authflow.utils.TicketShapeVertically

// data for the list of middle row
val items = listOf(
    Item("Flights", R.drawable.ic_flights),
    Item("Hotels", R.drawable.ic_hotels),
    Item("Trains", R.drawable.ic_trains),
    Item("Ferry", R.drawable.ic_ferry),
    Item("Bus", R.drawable.ic_bus)
)

val itemsData = listOf(
    ItemData("Mount Bromo", "Volcano in East Java", 4.5f, 150, R.drawable.iv_1),
    ItemData("Mount Bromo", "Volcano in East Java", 4.0f, 200, R.drawable.iv_2),
    ItemData("Mount Bromo", "Volcano in East Java", 4.8f, 180, R.drawable.iv_3)
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {

    Box() {
        Image(
            painter = painterResource(id = R.drawable.home_top),
            contentDescription = "Logo Image",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
        )
        Column(modifier = Modifier.padding(16.dp)) {
            AppBar()
            // search
            SearchFiled()
            //tickets
            CustomTicket()
            // sub section
            MiddleSectionRow(items)

            // item title
            ItemTitle()

            // card item
            HorizontalCardList(itemsData)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchFiled() {
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
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp, top = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF336749),
            unfocusedBorderColor = Color(0xFF336749),
            containerColor = Color.White,
            focusedLabelColor = Color(0xFF336749),
            unfocusedLabelColor = Color(0xFF336749)
        )
    )
}

@Composable
fun CustomTicket() {
    val shapeCustom = TicketShapeVertically(
        16.dp,
        CornerSize(20.dp)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
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
                .padding(
                    10.dp,
                )
                .background(Color.Transparent),
        ) {
            DateRow()
            FlightRouteRow()
            FlightDetailsRow()

            HorizontalDivider(
                modifier = Modifier.padding(
                    bottom = 15.dp,
                    top = 15.dp,
                    start = 10.dp,
                    end = 10.dp
                ),
                color = Color(0xFF336749),
                thickness = 0.35.dp
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 5.dp, end = 5.dp, bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
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
fun DateRow() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.clip(RoundedCornerShape(16.dp))
                .background(color = Color(0xff336749))

        ) {
            Text(
                text = "Upcoming",
                color = Color.White,
                modifier = Modifier.padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 6.dp,
                    bottom = 6.dp
                )
            )
        }
        Text(
            text = "24 March 2024",
            color = Color(0xff4B5563),
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Composable
fun FlightRouteRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
//        verticalAlignment = Alignment.CenterVertically
    ) {
        // First Column (cgk and 05:30)
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(end = 5.dp)
        ) {
            Text(
                text = "CGK",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 3.dp)
            )
            Text(text = "05:30", fontWeight = FontWeight.W200, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.width(8.dp)) // Space between column and airplane icon

        // Airplane Icon (you can use an image or an icon, using a simple text for now)
        Image(
            painter = painterResource(id = R.drawable.ic_airplain), // Replace with your drawable resource
            contentDescription = "Airplane Icon",
            modifier = Modifier.size(24.dp) // Adjust the size of the image
        )

        Spacer(modifier = Modifier.width(26.dp)) // Space between airplane icon and dotted line

        // Dotted line with arrow
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Bottom, // This centers the content vertically within the Column
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 16.dp)
                // Optionally, you can also center them horizontally if needed
            ) {
                DottedLineCuston()
                Text(text = "1h 30m", style = MaterialTheme.typography.bodySmall)
            }
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_right), // Replace with your drawable resource
                contentDescription = "Airplane Icon",
                modifier = Modifier.size(24.dp) // Adjust the size of the image
            )
        }

        Spacer(modifier = Modifier.width(26.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_airplain), // Replace with your drawable resource
            contentDescription = "Airplane Icon",
            modifier = Modifier.size(24.dp) // Adjust the size of the image
        )
        // Space between dotted line and second column
        Spacer(modifier = Modifier.width(8.dp))

        // Second Column (dps and 08:30)
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "DPS",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 3.dp)
            )
            Text(text = "08:30", fontWeight = FontWeight.W200, fontSize = 12.sp)
        }
    }
}

@Composable
fun FlightDetailsRow() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 12.dp, start = 5.dp)
    ) {
        Text(
            text = "Sentosa Air",
            color = Color(0xff4B5563),
            modifier = Modifier.padding(start = 10.dp)
        )
        // Dot before the second text
        Text(
            text = "•",
            color = Color(0xff4B5563),
            modifier = Modifier.padding(horizontal = 8.dp) // Adjust spacing between text and dot
        )
        Text(
            text = "Economy",
            color = Color(0xff4B5563),
            modifier = Modifier.padding(start = 10.dp)
        )
        // Dot before the second text
        Text(
            text = "•",
            color = Color(0xff4B5563),
            modifier = Modifier.padding(horizontal = 8.dp) // Adjust spacing between text and dot
        )
        Text(
            text = "Direct",
            color = Color(0xff4B5563),
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}


@Composable
fun DottedLineCuston() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    Canvas(Modifier.width(100.dp).height(1.dp)) {
        drawLine(
            color = Color(0xff5481C4),
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}


@Composable
fun MiddleSectionRow(items: List<Item>) {
    LazyRow(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()

    ) {
        items(items) { item ->
            // Each item in the list
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFADD2D7))
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.imageRes),
                        contentDescription = item.title,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.title,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun ItemTitle() {
    Row(
        modifier = Modifier
            .padding(top = 25.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Journey together",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xff4B5563)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "See all",
            color = Color(0xff4B5563)
        )
    }
}

@Composable
fun HorizontalCardList(items: List<ItemData>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(top = 20.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .width(180.dp), // Card width
//                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(4.dp), // Elevation for a slight shadow
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp), // Set image height to one third of card height
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 8.dp, end = 8.dp, top = 5.dp)
                ) {
                    // Image (One third of the card height)


                    // Item details: Title, Address, Rating
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = item.title,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xff336749))
                    )
                    Text(
                        text = item.address,
                        style = MaterialTheme.typography.labelSmall.copy(color = Color(0xff6C757D)),
                    )
                    Row {
                        Icon(
                            imageVector = Icons.Filled.Star, // Use the filled star icon
                            contentDescription = "Star",
                            tint = Color.Yellow,
                            modifier = Modifier.size(16.dp)
                                .padding(end = 5.dp) // Adjust the size of the star
                        )
                        Text(
                            text = "${item.rating}",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Gray
                        )
                    }


                    Spacer(modifier = Modifier.height(16.dp)) // Space between details and pricing

                    // Row with "Start from" and price
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Column {
                            Text(
                                text = "Start from",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color(
                                        0xff6C757D
                                    )
                                ),
                            )
                            Text(
                                text = "$ ${item.price}/pax",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = Color(
                                        0xff336749
                                    )
                                ),
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the next column to the right

                        // 3D2N Box
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .background(Color(0xFF336749)), // Box color
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "3D2N",
                                color = Color.White,
                                modifier = Modifier.padding(
                                    start = 10.dp,
                                    end = 10.dp,
                                    top = 5.dp,
                                    bottom = 5.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}






