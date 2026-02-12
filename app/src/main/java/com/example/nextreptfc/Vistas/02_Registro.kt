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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        -> Column (Logo y parrafo) (Weight -> 0.25)
                -> Box (fillMaxWidth (0.5f))
                    -> Img
                -> Text
        -> Card (Weight -> 0.75)
            -> Box (Para centrar la columna) (fillMaxSize)
                -> Column (fillMaxSize()) (fillMaxWidht -> 0.9f, fillMaxHeight)
                    -> Row (Entrar y Registrar) (Weight 0.1)
                        -> Card (fillMaxSize)
                            -> Box (fillMaxSize) Para alinear
                                -> Row (fillaMaxSize)
                                    -> Button (fillMaxWidth (0.3f)
                                        -> Text
                                    -> Button (fillMaxWidth (0.3f)
                                        -> Text
                    -> Row (Nombre y Apellidos) (weight 0.1)
                        -> Column (fillMaxWidth)
                            ->  Column (Nombre)
                                -> Text
                                -> TextField
                            ->  Column (Apellidos)
                                -> Text
                                -> TextField

                    -> Row (Correo Electronico) (weight 0.1)
                    -> Row (Contraseña)         (weight 0.1)
                    -> Row (Input + Términos)   (weight 0.05)
                    -> Button    (weight 0.1)
                    -> Text      (weight 0.05)
                    -> Column    (weight 0.3)
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

     Dejamos weitght 0.1 de espacio

 */
@Composable
fun Registro(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        // COLUMNA LOGO Y PARRAFO
        Column (
            modifier = Modifier
                .weight(0.25f)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize(0.5f)
            ){
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
        Card (
            modifier = Modifier
                .weight(0.75f)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){  // Para centrar la columna
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)     // Para que no coche con los bordes
                        .fillMaxHeight(0.95f)
                        .background(Color.Red),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    // ENTRAR Y REGISTRAR
                    Row(
                        modifier = Modifier
                            .weight(0.1f)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Card(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ){
                                Row (
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ){

                                    // BTN ENTRAR
                                    Button(
                                        onClick ={},
                                        modifier = Modifier
                                            .weight(0.3f)
                                    ) {
                                        Text(
                                            text = "Entrar"
                                        )
                                    }

                                    // BTN REGISTRARSE
                                    Button(
                                        onClick ={},
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
                            .weight(0.1f)
                            .fillMaxWidth()
                    ){

                    }

                    // Correo electrónico
                    Row(
                        modifier = Modifier
                            .weight(0.1f)
                            .fillMaxWidth()
                    ){

                    }

                    // Contraseña
                    Row(
                        modifier = Modifier
                            .weight(0.1f)
                            .fillMaxWidth()
                    ){

                    }

                    // Términos y condiciones
                    Row(
                        modifier = Modifier
                            .weight(0.05f)
                            .fillMaxWidth()
                    ){

                    }

                    // BOTON
                    Button(
                        modifier = Modifier
                            .weight(0.1f)
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
                            .weight(0.05f)
                    )

                    Column(
                        modifier = Modifier
                            .weight(0.3f)
                            .fillMaxSize()
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
fun PreviewRegistro(){
    Registro()
}