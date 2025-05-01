package com.maestrocorona.appferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Activity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nave1Screen()  // Se configura la pantalla con la interfaz Nave1Screen
        }
    }
}

@Composable
fun Nave1Screen() {
    // Componente Column que organiza los elementos de la pantalla de forma vertical
    Column(
        modifier = Modifier
            .fillMaxSize()  // La columna ocupa todo el tamaño disponible de la pantalla
    ) {
        // Título centrado
        Text(
            text = "Tecnologia innovadora",  // Título que describe la Nave 1
            fontSize = 28.sp,  // Tamaño de fuente grande
            fontWeight = FontWeight.ExtraBold,  // Peso de la fuente en negritas extra
            color = Color.Black,  // Color del texto
            textAlign = TextAlign.Center,  // Alineación centrada
            modifier = Modifier
                .fillMaxWidth()  // El texto ocupa todo el ancho disponible
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)  // Margen superior y en los lados
        )

        Spacer(modifier = Modifier.height(12.dp))  // Espacio entre el título y la imagen

        // Imagen sin borde, con esquinas redondeadas abajo
        Box(
            modifier = Modifier
                .fillMaxWidth()  // La caja ocupa todo el ancho disponible
                .weight(1f)  // La caja toma el espacio restante disponible
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))  // Esquinas redondeadas solo en la parte inferior
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_nave),  // Carga la imagen desde los recursos
                contentDescription = "Imagen de la Nave 1",  // Descripción de la imagen
                contentScale = ContentScale.Crop,  // Escalado para llenar el área de la imagen
                modifier = Modifier.fillMaxSize()  // La imagen ocupa todo el tamaño de la caja
            )
        }

        // Texto informativo adicional
        Column(
            modifier = Modifier
                .fillMaxWidth()  // La columna ocupa todo el ancho disponible
                .padding(20.dp),  // Añade margen alrededor del contenido
            horizontalAlignment = Alignment.CenterHorizontally  // Alineación horizontal centrada
        ) {
            Text(
                text = """
                    La Nave 1 de nuestra feria está dedicada a la tecnología más avanzada. 
                    En ella encontrarás las últimas innovaciones en dispositivos electrónicos, 
                    gadgets futuristas, inteligencia artificial, robótica y realidad virtual.
                """.trimIndent(),  // Texto informativo sobre la Nave 1
                fontSize = 16.sp,  // Tamaño de fuente más pequeño para el contenido
                color = Color.DarkGray,  // Color del texto
                textAlign = TextAlign.Justify  // Alineación justificada del texto
            )

            // Texto final con un mensaje adicional
            Text(
                text = "¡Vive la experiencia tabasqueña!",  // Mensaje final
                fontSize = 20.sp,  // Tamaño de fuente mediano
                fontWeight = FontWeight.Bold,  // Fuente en negrita
                color = Color.Black  // Color del texto
            )
        }
    }
}

@Preview(showBackground = true)  // Vista previa de la pantalla
@Composable
fun Nave1ScreenPreview() {
    Nave1Screen()  // Muestra la vista previa de la pantalla Nave1Screen
}
