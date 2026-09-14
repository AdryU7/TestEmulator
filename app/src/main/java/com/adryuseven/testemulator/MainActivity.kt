package com.adryuseven.testemulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.adryuseven.testemulator.ui.theme.TestEmulatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestEmulatorTheme {
                //Components()
                //MyLazyRowText()
                //MyLazyRowImages()
                //MyLazyRowImageWeb()
                //MyLazyVerticalGrid()
                MyLazyHorizontalGrid()
            }
        }
    }
}
// ==== LISTS ====
// == LAZY COLUMN ==
@Composable
fun MyLazyColumn() {
    val itemsList = List(100) {"Elemento Nº $it"}

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Encabezado de la lista",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp
            )
        }

        items(itemsList) { element ->
            Text(text = element, fontSize = 20.sp)
        }

        item {
            Text(
                text = "Pie de la lista",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp
            )
        }
    }
}
// == LAZY ROW ==
@Composable
fun MyLazyRowText() {
    val itemsLanguages = listOf("Kotlin","JavaScript","Python","Java","Dart","PHP")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemsLanguages) { language ->
            Text(
                text = language,
                modifier = Modifier
                    .padding(10.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp),
                color = Color.White,
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun MyLazyRowImages() {
    val listImages = listOf(
        R.drawable.perro,
        R.drawable.zorro,
        R.drawable.erizo,
        R.drawable.loro,
        R.drawable.conejo,
        R.drawable.oso
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listImages){image ->
            Image(
                painter = painterResource(id = image),
                contentDescription = "Imagen del animal",
                modifier = Modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun MyLazyRowImageWeb() {
    val imageUrls = listOf(
        "https://cdn.pixabay.com/photo/2012/04/26/21/56/arequipa-43281_1280.jpg",
        "https://cdn.pixabay.com/photo/2021/11/10/14/27/lima-6784100_1280.jpg",
        "https://cdn.pixabay.com/photo/2015/02/13/21/36/peru-635857_1280.jpg",
        "https://cdn.pixabay.com/photo/2018/12/12/06/51/trujillo-3870245_1280.jpg",
        "https://cdn.pixabay.com/photo/2012/04/26/21/56/arequipa-43282_1280.jpg"
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(imageUrls){imageUrl ->
            AsyncImage(
                model = imageUrl,
                contentDescription = "Imagen de la url",
                modifier = Modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}
// == LAZY VERTICAL GRID ==
@Composable
fun MyLazyVerticalGrid() {
    val myElements = List(20) {
        "Elemento ${it+1}"
    }

    LazyVerticalGrid(
        //columns = GridCells.Adaptive(120.dp), /*Ancho minimo de la celda*/
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(myElements){ myElement ->
            GridItem(element = myElement)
        }
    }
}
@Composable
fun GridItem(element: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Iconos de la celda",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = element, fontWeight = FontWeight.Bold)
        }
    }
}
// == LAZY HORIZONTAL GRID ==
@Composable
fun MyLazyHorizontalGrid() {
    val myElements = List(20) {
        "Elemento ${it+1}"
    }

    LazyHorizontalGrid(
        //rows = GridCells.Fixed(4),
        rows = GridCells.Adaptive(100.dp), /*La celda debe tener minimo 100.dp de alto*/
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(myElements){ myElement ->
            GridItemHorizontal(element = myElement)
        }
    }
}
@Composable
fun GridItemHorizontal(element: String) {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .border(
                2.dp,
                MaterialTheme.colorScheme.primary,
                RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = element,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}
// ==== XXXXX ====

@Composable
fun Components() {
    MyConstraintLayout() // Layout
}

// ==== LAYOUTS ====
@Composable
fun MyColumn() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        MyOutlinedButton()
        MyTextButton()
        MyImage()
        MyIcon()
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Elemento 1")
        Text(text = "Elemento 2")
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagen_fondo),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Text(
            text = "Curso de Jetpack Compose",
            style = TextStyle(
                color = Color.Black,
                fontSize = 25.sp
            )
        )

        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text = "Presione")
        }
    }
}

@Composable
fun MyConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // Referencias para utilizar las restricciones
        val (image, name, description, button) = createRefs()

        Image (
            painter = painterResource(id = R.drawable.perfil),
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .size(100.dp)
                // Aplicar restricciones con el elemento parent para posicionar la imagen
                .constrainAs(image){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Cristiano Ronaldo",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                // Aplicar restricciones con el elemento image para posicionar el nombre
                .constrainAs(name){
                    top.linkTo(image.top)
                    start.linkTo(image.end, margin = 16.dp) // Dar margen para dar distancia al contenido
                }
        )

        Text(
            text = "Jugador de Portugal",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(description){
                    // Posicionar la descripcion con el elemento name y un margen
                    top.linkTo(name.bottom, margin = 4.dp)
                    start.linkTo(name.start)
                    // Alinear con el borde derecho del contenedor
                    end.linkTo(parent.end)
                    // Ocupar t0do el ancho de la parte izquierda y derecha del texto
                    width = Dimension.fillToConstraints
                }
        )

        Button(
            onClick = {},
            modifier = Modifier
                .constrainAs(button){
                    top.linkTo(description.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text(text = "Seguir")
        }
    }
}
// ==== XXXXX ====

/* == Previous Components ==
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

   == Horizontal Divider ==
    Text(text = "Seccion 1",
            style = MaterialTheme.typography.bodyLarge)

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 15.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary
        )

        Text(text = "Seccion 2",
            style = MaterialTheme.typography.bodyLarge)

   == Circular and Linear Progress Indicator ==
        CircularProgressIndicator(
            modifier = Modifier.size(60.dp),
            strokeWidth = 6.dp,
            color = MaterialTheme.colorScheme.primary,
        )

        Spacer(modifier = Modifier.height(30.dp))

        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary
        )
   == CANVAS ==
   Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val backgroundColor = MaterialTheme.colorScheme.primary

        Canvas(
            modifier = Modifier
                .size(300.dp)
                .padding(15.dp)
        ) {
            drawCircle(
                color = backgroundColor,
                radius = size.minDimension/4 // radius = 75
            )
        }
    }
*/

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