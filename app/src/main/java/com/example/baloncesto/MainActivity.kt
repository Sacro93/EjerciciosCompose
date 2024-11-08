package com.example.baloncesto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baloncesto.ui.theme.BaloncestoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarcadorApp()
        }

    }
}

@Composable
fun MarcadorApp() {
    var marcadorLocal by remember { mutableStateOf(0) }
    var marcadorVisitante by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Text(
            text = "Puntaje de equipos",
            style = MaterialTheme.typography.headlineLarge.copy(fontSize = 24.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { marcadorLocal = 0; marcadorVisitante = 0 }) {
            Text(text = "Reiniciar")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Local", fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "$marcadorLocal",
                    style = MaterialTheme.typography.headlineLarge.copy(fontSize = 24.sp),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Button(onClick = { marcadorLocal += 1 }) {
                    Text(text = "+1 Local")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { marcadorLocal += 2 }) {
                    Text(text = "+2 Local")
                }
                Button(onClick = { marcadorLocal -= 1 }) {
                    Text(text = "-1 Local")
                }

            }

            //Utilizo mutableStateOf para almacenar los marcadores y los botones  Button para actualizarlos. Al hacer clic
            // en los botones, se ejecuta el código dentro de onClick,que incrementa el marcador correspondiente en 1 o 2 unidades.
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Visitante",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "$marcadorVisitante",
                    style = MaterialTheme.typography.headlineLarge.copy(fontSize = 24.sp),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Button(onClick = { marcadorVisitante + 1 }) { Text(text = "+1 Visitante") }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { marcadorVisitante += 2 }) { Text(text = "+2 Visitante") }
                Button(onClick = { marcadorVisitante -= 1 }) {
                    Text(text = "-1 Visitante")
                }
            }


        }

    }

}
