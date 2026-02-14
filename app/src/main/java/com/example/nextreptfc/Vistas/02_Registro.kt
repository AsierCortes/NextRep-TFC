package com.example.nextreptfc.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                -> Column (fillMaxSize(0.95f)) Aqui esta el scroll
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
                    -> Button (Entrar)
                    -> Text
                    -> Column
                        -> Card (Google)
                            -> Row (fillMaxWidht)
                                -> ICON
                                -> Text
                        -> Card (Apple)
                            -> Row (fillMaxWidht)
                                -> ICON
                                -> Text
                        -> Card (Faceebok)
                            -> Row (fillMaxWidht). No es necesario poner una box ya que la rom va a ocupar todoo
                                -> ICON
                                -> Text
     Cambio de planteamiento dentro de la column (Card) vamos a meter un scroll, por tanto
     los weights ya no hacen falta, pierde todoo el sentido. He hecho cambios respecto a la
     estructura inicial

     Dejamos weitght 0.1 de espacio

 */
@Composable
fun Registro(irAIniciarSesion : () -> Unit, irAPerfil : () -> Unit) {
    val state = rememberScrollState()   // Para que recuerde en que parte se encuentra
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasenia by remember { mutableStateOf("") }
    var terminos by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
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
                .fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {  // Para centrar la columna
                Column(
                    modifier = Modifier
                        .fillMaxSize(0.95f)     // Para que no coche con los bordes
                        //.background(Color.Red)
                        .verticalScroll(state),     // Para que sea scrolleable
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    Text(
                        text = "Registro",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,

                        modifier = Modifier
                            .padding(bottom = 10.dp)    // Le damos un margen inferior extra
                    )


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
                                text = "Nombre",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.bodyMedium

                            )
                            TextField(
                                value = nombre,
                                onValueChange = { nombre = it },

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
                                text = "Apellidos",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.bodyMedium


                            )
                            TextField(
                                value = apellidos,
                                onValueChange = { apellidos = it }
                            )


                        }
                    }

                    // Correo electrónico
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Correo Electrónico",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.bodyMedium


                            )

                            TextField(
                                value = contrasenia,
                                onValueChange = { contrasenia = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }

                    }

                    // Contraseña
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Contraseña",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.bodyMedium


                            )

                            TextField(
                                value = "",
                                onValueChange = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }

                    }

                    // Términos y condiciones
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Checkbox(
                            checked = terminos,
                            onCheckedChange = { terminos = !terminos }
                        )

                        Text(
                            text = "Acepto los Términos y Condiciones y la Política de Privacidad",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodySmall

                        )
                    }

                    // BOTON
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {irAPerfil()}, // Te lleva al perfil
                        shape = RoundedCornerShape(6.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 6.dp,    // En reposo la sombra es de 6.dp
                            pressedElevation = 2.dp     // Cuando pulsas la sombre pasa a 2.dp
                        )
                    ) {
                        Text(
                            text = "CREAR CUENTA",
                            color = Color.White
                        )
                    }

                    Text(
                        text = "O",
                        color = MaterialTheme.colorScheme.onSurface
                    )


                    // BTN ENTRAR
                    Button(
                        onClick = {irAIniciarSesion()},
                        modifier = Modifier
                            .fillMaxWidth(0.5f),
                        shape = RoundedCornerShape(6.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 6.dp,    // En reposo la sombra es de 6.dp
                            pressedElevation = 2.dp     // Cuando pulsas la sombre pasa a 2.dp
                        )
                    ) {
                        Text(
                            text = "INICIAR SESIÓN",
                            color = Color.White
                        )
                    }


                    // REGISTRARSE PARRAFO
                    Text(
                        text = "------------- REGISTRARSE CON -------------",
                        color = MaterialTheme.colorScheme.onSurface

                    )

                    // REGISTRARSE CON GOOGLE, faceeobkk
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        // Se que se puede poner un botón pero prefiero hacerlo en una card clickeable
                        // Google
                        Card(
                            onClick = { println("Registrarse con Google") },
                            modifier = Modifier
                                .fillMaxWidth(0.7f),
                            shape = RectangleShape
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Icon(
                                    painter = painterResource(id = R.drawable.google_icon),
                                    contentDescription = "Google",
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(10.dp)
                                )

                                Spacer(Modifier.padding(2.dp))

                                Text(
                                    text = "Google",
                                    modifier = Modifier
                                        .padding(10.dp),
                                    style = MaterialTheme.typography.bodyLarge
                                )

                            }
                        }

                        // Apple
                        Card(
                            onClick = { println("Registrarse con Apple") },
                            modifier = Modifier
                                .fillMaxWidth(0.7f),
                            shape = RectangleShape
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Icon(
                                    painter = painterResource(id = R.drawable.apple_icon),
                                    contentDescription = "Google",
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(10.dp)
                                )

                                Spacer(Modifier.padding(2.dp))

                                Text(
                                    text = "Apple",
                                    modifier = Modifier
                                        .padding(10.dp),
                                    style = MaterialTheme.typography.bodyLarge

                                )

                            }
                        }


                        // Facebook
                        Card(
                            onClick = { println("Registrarse con Facebook") },
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .padding(bottom = 35.dp),   // Dejamos espacio abajo
                            shape = RectangleShape
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Icon(
                                    painter = painterResource(id = R.drawable.facebook_icon),
                                    contentDescription = "Google",
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(10.dp)
                                )

                                Spacer(Modifier.padding(2.dp))

                                Text(
                                    text = "Facebook",
                                    modifier = Modifier
                                        .padding(10.dp),
                                    style = MaterialTheme.typography.bodyLarge
                                )

                            }
                        }


                    }


                }


            }
        }
    }


}


@Composable
@Preview
fun PreviewRegistro() {
    //Registro()
}