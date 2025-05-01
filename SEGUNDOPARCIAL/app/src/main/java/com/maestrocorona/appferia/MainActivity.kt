package com.maestrocorona.appferia

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Habilita el modo de pantalla completa (Edge-to-edge)
        setContent {
            MainScreen(onNavigateToSecondActivity = { naveName ->  // Define el contenido de la pantalla principal
                val intent = when (naveName) {  // Controla la navegación basada en la opción seleccionada
                    "Negocios de la Nave 1" -> Intent(this, Activity3::class.java)
                    "Negocios de la Nave 2" -> Intent(this, Activity4::class.java)
                    "Negocios de la Nave 3" -> Intent(this, Activity5::class.java)
                    "Fechas importantes" -> Intent(this, Activity2::class.java)
                    "Artistas" -> Intent(this, Activity6::class.java)
                    else -> return@MainScreen
                }
                startActivity(intent)  // Inicia la actividad correspondiente
            })
        }
    }
}

@Composable
fun MainScreen(onNavigateToSecondActivity: (String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {  // Usa Box para posicionar elementos encima de un fondo
        // Fondo con imagen
        Image(
            painter = painterResource(id = R.drawable.fondo_logo),  // Carga la imagen de fondo
            contentDescription = "Fondo decorativo",
            modifier = Modifier.fillMaxSize(),  // Ajusta el fondo a la pantalla
            contentScale = ContentScale.Crop  // Ajusta la escala de la imagen para cubrir toda la pantalla
        )

        // Contenido principal encima del fondo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),  // Espaciado alrededor de los elementos dentro del Column
            horizontalAlignment = Alignment.CenterHorizontally,  // Alinea los elementos horizontalmente en el centro
            verticalArrangement = Arrangement.spacedBy(16.dp)  // Espacio entre los elementos
        ) {
            // Cada uno de estos BusinessItem representa una opción de negocio
            BusinessItem("Negocios de la Nave 1", onNavigateToSecondActivity)
            BusinessItem("Negocios de la Nave 2", onNavigateToSecondActivity)
            BusinessItem("Negocios de la Nave 3", onNavigateToSecondActivity)
            BusinessItem("Artistas", onNavigateToSecondActivity)

            // Botón de 'Fechas importantes'
            Button(
                onClick = { onNavigateToSecondActivity("Fechas importantes") },
                modifier = Modifier.padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4))  // Color personalizado
            ) {
                Text("Fechas importantes", fontFamily = FontFamily.SansSerif)  // Texto en el botón con una fuente sans-serif
            }
        }
    }
}

@Composable
fun BusinessItem(text: String, onNavigateToSecondActivity: (String) -> Unit) {
    val purpleLight = Color(0xFF6650a4)  // Color de fondo personalizado para la tarjeta

    // Tarjeta que representa un negocio, al hacer clic navega a la actividad correspondiente
    Card(
        modifier = Modifier
            .fillMaxWidth()  // Hace que la tarjeta ocupe todo el ancho
            .height(145.dp)  // Altura fija para la tarjeta
            .clickable { onNavigateToSecondActivity(text) },  // Accionable, pasa el nombre del negocio al hacer clic
        colors = CardDefaults.cardColors(
            containerColor = purpleLight,  // Color de fondo de la tarjeta
            contentColor = Color.White  // Color del texto e íconos dentro de la tarjeta
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),  // Padding dentro de la tarjeta
            verticalAlignment = Alignment.CenterVertically  // Alineación vertical del contenido
        ) {
            // Imagen dentro de la tarjeta (el logo del negocio)
            Image(
                painter = painterResource(id = R.drawable.logo_restt),  // Carga la imagen del logo
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(120.dp)  // Tamaño fijo de la imagen
                    .padding(end = 16.dp)  // Padding derecho para separar la imagen del texto
            )
            // Texto dentro de la tarjeta
            Text(
                text = text,
                modifier = Modifier.padding(8.dp),  // Padding alrededor del texto
                fontFamily = FontFamily.SansSerif,  // Fuente sans-serif
                style = MaterialTheme.typography.bodyLarge  // Estilo del texto (gran tamaño)
            )
        }
    }
}
