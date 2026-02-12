package com.example.nextreptfc.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nextreptfc.R

/*
    Column (fillMaxSize)
        -> Column (Logo y parrafo) (Weight -> 0.3)
                -> Box (fillMaxWidth (0.5f))
                    -> Img
                -> Text
        -> Card (Weight -> 0.7)
            -> Box (Para centrar la columna) (fillMaxSize)
                -> Column (fillMaxSize()) (fillMaxWidht -> 0.9f, fillMaxHeight) Aqui esta el scroll
                    -> Row (Entrar y Registrar) (Weight 0.1)
                        -> Card (fillMaxSize)
                            -> Box (fillMaxWidht) Para alinear
                                -> Row (fillMaxWidht)
                                    -> Button (fillMaxWidth (0.3f)
                                        -> Text
                                    -> Button (fillMaxWidth (0.3f)
                                        -> Text
                    -> Row (Nombre y Apellidos)
                        ->  Column (Nombre) (weight 0.4f)
                            -> Text
                            -> TextField
                        ->  Column (Apellidos) (weight 0.4f)
                            -> Text
                            -> TextField

                    -> Row (Correo Electronico)
                        -> Column
                            -> Text
                            -> TextField
                    -> Row (Contraseña)
                    -> Row (Input + Términos)
                    -> Button
                    -> Text
                    -> Column
                        -> Card (Google)
                            -> Row
                                -> ICON
                                -> Text
                        -> Card (Apple)
                            -> Row
                                -> ICON
                                -> Text
                        -> Card (Faceebok)
                            -> Row
                                -> ICON
                                -> Text
     Cambio de planteamiento dentro de la column (Card) vamos a meter un scroll, por tanto
     los weights ya no hacen falta, pierde todoo el sentido
     Dejamos weitght 0.1 de espacio

 */
@Composable
fun Registro() {
    val state = rememberScrollState()   // Para que recuerde en que parte se encuentra
    var nombre by remember { mutableStateOf("asdfasdf") }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        // COLUMNA LOGO Y PARRAFO
        Column(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize(0.5f)
            ) {
                Image(
                    painter = painterResource(R.drawable.logosinslogan),
                    contentDescription = "Fotos logo sin slogan",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = "Únete al equipo y supera tus límites"
            )

        }

        // CARD (Inputs y todoo lo demás)
        Card(
            modifier = Modifier
                .weight(0.7f)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {  // Para centrar la columna
                Column(
                    modifier = Modifier
                        .fillMaxSize(0.95f)     // Para que no coche con los bordes
                        .background(Color.Red)
                        .verticalScroll(state),     // Para que sea scrolleable
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    // ENTRAR Y REGISTRAR
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(), // Obligatoriamente la box tiene que ser fillMaxSize, para centrar la row luego
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {

                                    // BTN ENTRAR
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .weight(0.3f)
                                    ) {
                                        Text(
                                            text = "Entrar"
                                        )
                                    }

                                    // BTN REGISTRARSE
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .weight(0.3f)
                                    ) {
                                        Text(
                                            text = "Registrarse"
                                        )
                                    }
                                }
                            }

                        }
                    }

                    // Nombre y apellidos
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        // NOMBRE
                        Column(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Nombre"
                            )
                            TextField(
                                value = nombre,
                                onValueChange = {nombre = it}
                            )
                        }

                        // APELLIDOS
                        Column(
                            modifier = Modifier
                                .weight(0.4f)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Apellidos"
                            )
                            TextField(
                                value = "",
                                onValueChange = {}
                            )


                        }
                    }

                    // Correo electrónico
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = "Correo Electrónico"
                            )

                            TextField(
                                value = "",
                                onValueChange = {}
                            )
                        }

                    }

                    // Contraseña
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                    }

                    // Términos y condiciones
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                    }

                    // BOTON
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {}, // Te lleva al perfil
                        shape = RoundedCornerShape(6.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 6.dp,    // En reposo la sombra es de 6.dp
                            pressedElevation = 2.dp     // Cuando pulsas la sombre pasa a 2.dp
                        )
                    ) {
                        Text(
                            text = "CREAR CUENTA"
                        )
                    }

                    // REGISTRARSE PARRAFO
                    Text(
                        text = "O REGISTRARSE CON",
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    // REGISTRARSE CON GOOGLE, faceeobkk
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text("Aqui iran las cards GOogle faceboik etcl")
                    }


                }
            }
        }


    }
}

@Composable
@Preview
fun PreviewRegistro() {
    Registro()
}