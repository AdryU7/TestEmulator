package com.adryuseven.testemulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                Components()
            }
        }
    }
}

@Composable
fun Components() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Icon(Icons.Default.Person, contentDescription = "Icono persona")
            Text(text = "Presionar")
        }

        Spacer(modifier = Modifier.height(30.dp))
        MyOutlinedButton()
        Spacer(modifier = Modifier.height(30.dp))
        MyTextButton()
        Spacer(modifier = Modifier.height(30.dp))
        MyImage()
        Spacer(modifier = Modifier.height(30.dp))
        MyIcon()
    }
}

@Composable
fun MyOutlinedButton() {
    OutlinedButton(
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .shadow(4.dp, shape = RoundedCornerShape(15.dp))
    ) {
        Icon(Icons.Default.Favorite,
            contentDescription = "Icono de favoritos",
            modifier = Modifier.size(25.dp))
        Text(text = "Favoritos")
    }
}

@Composable
fun MyTextButton() {
    TextButton(
        onClick = {},
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(text = "Presione aquí")
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

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.mi_imagen),
        contentDescription = "Descripcion de la imagen",
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Yellow, CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Default.Home,
        contentDescription = "Descripcion del icono",
        modifier = Modifier.size(35.dp),
        tint = MaterialTheme.colorScheme.primary
    )
}