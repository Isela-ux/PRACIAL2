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

class Activity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nave3Screen()  // Configura el contenido de la pantalla con la interfaz Nave3Screen
        }
    }
}

@Composable
fun Nave3Screen() {
    Column(
        modifier = Modifier.fillMaxSize()  // La columna ocupa todo el tamaño disponible de la pantalla
    ) {
        // Título centrado
        Text(
            text = "Artesanias Tabasqueñas",  // Título que describe la Nave 3
            fontSize = 28.sp,  // Tamaño de la fuente grande
            fontWeight = FontWeight.ExtraBold,  // Estilo en negrita
            color = Color.Black,  // Color del texto
            textAlign = TextAlign.Center,  // Alineación centrada
            modifier = Modifier
                .fillMaxWidth()  // El texto ocupa todo el ancho disponible
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)  // Margen superior y en los lados
        )

        Spacer(modifier = Modifier.height(12.dp))  // Espacio entre el título y la imagen

        // Imagen con esquinas redondeadas en la parte inferior
        Box(
            modifier = Modifier
                .fillMaxWidth()  // La caja ocupa todo el ancho disponible
                .weight(1f)  // La caja toma el espacio restante disponible
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))  // Esquinas redondeadas en la parte inferior
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_res),  // Carga la imagen desde los recursos
                contentDescription = "Artesanías Tabasqueñas",  // Descripción de la imagen
                contentScale = ContentScale.Crop,  // Escalado para llenar el área de la imagen
                modifier = Modifier.fillMaxSize()  // La imagen ocupa todo el tamaño de la caja
            )
        }

        // Texto informativo adicional
        Column(
            modifier = Modifier
                .fillMaxWidth()  // La columna ocupa todo el ancho disponible
                .padding(20.dp),  // Añade margen alrededor del contenido
            horizontalAlignment = Alignment.CenterHorizontally  // Alineación centrada horizontalmente
        ) {
            Text(
                text = """
                    En la Nave 3, encontrarás una selecta variedad de puestos con las más bellas artesanías de la región de Tabasco. 
                    Disfruta de la riqueza cultural que ofrecen nuestros artesanos locales. 
                    Te invitamos a explorar y admirar productos únicos, hechos a mano con amor y tradición. 
                """.trimIndent(),  // Texto informativo sobre las artesanías de la Nave 3
                fontSize = 16.sp,  // Tamaño de fuente más pequeño para el contenido
                color = Color.DarkGray,  // Color del texto
                textAlign = TextAlign.Justify  // Alineación justificada del texto
            )

            // Texto final con mensaje adicional
            Text(
                text = "¡Ven y vive la experiencia de la cultura tabasqueña!",  // Mensaje final
                fontSize = 20.sp,  // Tamaño de fuente mediano
                fontWeight = FontWeight.Bold,  // Fuente en negrita
                color = Color.Black  // Color del texto
            )
        }
    }
}

@Preview(showBackground = true)  // Vista previa de la pantalla
@Composable
fun Nave3ScreenPreview() {
    Nave3Screen()  // Muestra la vista previa de la pantalla Nave3Screen
}
