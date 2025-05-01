package com.maestrocorona.appferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreen(onBackPressed = { finish() })  // Configura el contenido de la actividad con SecondScreen
        }
    }
}

@Composable
fun SecondScreen(onBackPressed: () -> Unit) {
    // Pantalla secundaria con lista de restaurantes
    Surface(
        modifier = Modifier.fillMaxSize(),  // El contenedor de la superficie ocupa toda la pantalla
        color = MaterialTheme.colorScheme.background  // Color de fondo, tomará el valor definido en el tema de la app
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()  // La columna ocupa toda la pantalla
                .padding(16.dp),  // Añade un espaciado interno alrededor de los elementos dentro de la columna
            horizontalAlignment = Alignment.CenterHorizontally,  // Alinea los elementos horizontalmente en el centro
            verticalArrangement = Arrangement.spacedBy(16.dp)  // Espaciado entre los elementos en la columna
        ) {
            // Lista de restaurantes representada por textos
            Text("Restaurante 1")
            Text("Restaurante 2")
            Text("Restaurante 3")

            // Botón para regresar a la pantalla anterior
            Button(
                onClick = onBackPressed,  // Al hacer clic, ejecuta la función onBackPressed, que llama a 'finish()' para cerrar la actividad
                modifier = Modifier.padding(top = 16.dp)  // Añade un espaciado superior al botón
            ) {
                Text("Fechas importantes")  // Texto dentro del botón
            }
        }
    }
}
