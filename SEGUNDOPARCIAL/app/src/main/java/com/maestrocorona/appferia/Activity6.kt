package com.maestrocorona.appferia

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.maestrocorona.appferia.ui.theme.AppFeriaTheme

class Activity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFeriaTheme {
                CarteleraPantalla()
            }
        }
    }
}

@Composable
fun CarteleraPantalla() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),  // Sin padding para aprovechar toda la pantalla
        verticalArrangement = Arrangement.Top,  // Posicionamos los elementos en la parte superior
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen que ocupa toda la pantalla
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.80f)  // Ajusta el tamaño de la imagen, 80% de la pantalla
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_of), // Asegúrate que el archivo exista en res/drawable
                contentDescription = "Imagen de cartelera",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop  // Asegura que la imagen ocupe el espacio correctamente
            )
        }

        // Botón para volver al inicio, debajo de la imagen
        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre la imagen y el botón
        Button(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp), // Ajusta el tamaño del botón
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0)) // Color morado
        ) {
            Text("Ir al inicio", color = Color.White)
        }
    }
}
