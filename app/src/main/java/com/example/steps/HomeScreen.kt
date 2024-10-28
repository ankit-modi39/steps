package com.example.steps
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
//import androidx.compose.material3.TopAppBar
//
//
//@Composable
//fun HomeScreen(name: String) {
//    Scaffold(
//        topBar = { MyTopBar() },
//        bottomBar = { MyBottomBar() }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .padding(16.dp)
//        ) {
//            Text(text = "Welcome to the Home Screen, $name!")
//            // Add more UI elements here as needed
//        }
//    }
//}
//
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    TopAppBar(
        title = { Text("Today") },
        colors = TopAppBarDefaults.mediumTopAppBarColors()
    )
}

@Composable
fun MyBottomBar() {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier.height(70.dp) // Adjust height as needed
    ) {
        // Each item will take equal space
        BottomNavigationItem(
            icon = Icons.Filled.Home,
            label = "Home",
            onClick = { /* Handle home click */ }
        )
        BottomNavigationItem(
            icon = Icons.Filled.Person,
            label = "Profile",
            onClick = { /* Handle profile click */ }
        )
    }
}

@Composable
fun RowScope.BottomNavigationItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = icon, contentDescription = label)
        Text(
            text = label,
            fontSize = 12.sp, // Adjust font size as needed
            color = Color.White // Adapt to your theme color
        )
    }
}





@Composable
fun HomeScreen(stepsCount: Int) {
    Scaffold(
        topBar = { MyTopBar() },
        bottomBar = { MyBottomBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StepsCountBox(stepsCount)
            Spacer(modifier = Modifier.height(16.dp))
            PlayPauseButton()
            Spacer(modifier = Modifier.height(24.dp))
            StatsRow()
        }
    }
}

@Composable
fun StepsCountBox(stepsCount: Int) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(Color(0xFFB3E5FC), shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$stepsCount Steps",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun PlayPauseButton() {
    var isPlaying by remember { mutableStateOf(false) }
    Button(
        onClick = { isPlaying = !isPlaying },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0288D1))
    ) {
        Icon(
            imageVector = if (isPlaying) Icons.Filled.Clear else Icons.Filled.PlayArrow,
            contentDescription = if (isPlaying) "Pause" else "Play",
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = if (isPlaying) "Pause" else "Play",
            color = Color.White
        )
    }
}

@Composable
fun StatsRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        StatItem(label = "Km", value = "5.2")
        StatItem(label = "Kcal", value = "200")
        StatItem(label = "Time", value = "1h 30m")
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        // Placeholder for icon, replace with actual icons if available
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(Color.Gray, shape = RoundedCornerShape(50))
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = value, fontWeight = FontWeight.Bold)
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
    }
}
