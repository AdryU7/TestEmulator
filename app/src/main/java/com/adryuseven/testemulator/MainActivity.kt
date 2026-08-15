package com.adryuseven.testemulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adryuseven.testemulator.ui.theme.TestEmulatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestEmulatorTheme {
                MyText()
            }
        }
    }
}

@Composable
fun MyText() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Texto con modificadores",
            fontSize = 25.sp,
            modifier = Modifier // los eventos y elementos se aplican de forma secuencial
                .clickable {

                }
                .background(Color.Green)
                .border(2.dp, Color.Black)
                .padding(16.dp)
        )
    }
}
/*
@Composable
fun Greetings(name: String) {
    Text(text = "Hi, $name!")
}

@Preview(
    name = "Vista previa funcion",
    showBackground = true,
    widthDp = 200,
    heightDp = 100
)
@Composable
fun GreetingsPreview(){
    Greetings(name = "Jorge")
}*/