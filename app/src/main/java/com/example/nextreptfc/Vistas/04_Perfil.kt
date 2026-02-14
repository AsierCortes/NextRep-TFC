package com.example.nextreptfc.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nextreptfc.R

/*
    Planteamiento:

    Column
        -> Card (fillMaxSize) (Para que haya contraste en modo claro con las cards)
            -> Box (fillMaxSize 0.9f)   Para que le de ese toque de tarjeta
                -> Column (fillMaxSize (0.9f)) (Scrolleable)
                    -> DatosPerfil()
                        -> Box  (fillMaxWidth 0.4f)
                            -> Img
                        -> Column (Nombre, Primer Apellido y nombre usuario) (fillMaxWidht 0.4f)
                            -> Text (Nombre y Primer apellido)
                            -> Row
                                -> Nombre Usuario
                                -> Icono editar
                        -> Card (fillMaxWidht 0.4f)
                            -> Row (fillMaxWidht)
                                -> Icono Calendario
                                -> Text
                        -> Row
                            -> Card (Weight 0.3f)       (IMC)
                                -> Box (Para centrar)
                                    -> Column (fillMaxSize (0.9)
                                        -> Icono
                                        -> Text
                                        -> Text
                            -> Card (Weight 0.3f)       (KCAL MAX)
                                -> Box (Para centrar)
                                    -> Column (fillMaxSize (0.9)
                                        -> Icono
                                        -> Text
                                        -> Text
                            -> Card (Weight 0.3f)       (AGUA)
                                -> Box (Para centrar)
                                    -> Column (fillMaxSize (0.9)
                                        -> Icono
                                        -> Text
                                        -> Text

                    -> MedidasYObjetivos()
                        -> Column (fillMaxWidth 0.9f)
                            -> Text  (align start). Izq
                            -> Card (fillMaxWidht 0.9f)
                                -> Box (fillMaxWidht) Para centrar
                                    -> Column (fillMaxWidht)
                                        (Peso)
                                        ->  Row
                                            -> Row
                                                -> Icon
                                                -> Text
                                            -> Row
                                                -> Text
                                                -> Icono >
                                         HorizontalDivider: https://developer.android.com/develop/ui/compose/components/divider
                                        (Objetivo etc.)
                                        ->  Row
                                            -> Row
                                                -> Icon
                                                -> Text
                                            -> Row
                                                -> Text
                                                -> Icono >



 */
@Composable
fun Perfil() {
    val state = rememberScrollState()   // Para que recuerde en que parte se encuentra

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(0.95f),    // 95% de le la columna general
            shape = RectangleShape
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight()
                        .verticalScroll(state),     // Para que sea scrolleable
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    DatosPresentacion()
                    MedidasYObjetivos()
                }
            }

        }

    }
}


@Composable
fun DatosPresentacion() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Foto de Perfil
        Box(
            modifier = Modifier.fillMaxWidth(0.4f)
        ) {
            Image(
                painter = painterResource(R.drawable.deku),
                contentDescription = "Foto de perfil ejemplo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(Modifier.padding(15.dp))

        // Nombre, apellido y Nombre usuario
        Column(
            modifier = Modifier.fillMaxWidth(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)    // Un poco de espacio entre nombre y nombre usuario
        ) {

            // Nombre y apelldio
            Text(
                text = "Asier Cortés"
            )

            // Nombre Usuario
            Text(
                text = "@Asier.578"
            )
        }
        Spacer(Modifier.padding(10.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(0.6f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp), // Espacio dentro de la card
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Fecha de registro",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(Modifier.padding(2.dp))      // Un pco de separacion entre el icono y la fecha

                    Text(
                        text = "Miembro desde 2024", textAlign = TextAlign.Center
                    )

                }
            }
        }

        Spacer(Modifier.padding(10.dp))

        // IMC; KCAL Y AGUA
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // IMC
            Card(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth()     // Que ocupe todoo lo que pueda respecto al weight
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .align(Alignment.CenterStart)
                            .padding(top = 10.dp, bottom = 10.dp),    // Un pco de margen tanto arriba como abajo

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.corazonicono),
                            contentDescription = "FIcono Corazon",
                            modifier = Modifier.size(50.dp)
                        )

                        Spacer(Modifier.padding(6.dp))
                        Text(
                            text = "24.5"
                        )

                        Spacer(Modifier.padding(4.dp))

                        Text(
                            text = "IMC NORMAL", textAlign = TextAlign.Center
                        )

                    }
                }
            }

            // IMC
            Card(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth()     // Que ocupe todoo lo que pueda respecto al weight
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .padding(
                                top = 10.dp, bottom = 10.dp
                            ),    // Un pco de margen tanto arriba como abajo
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.corazonicono),
                            contentDescription = "FIcono Corazon",
                            modifier = Modifier.size(50.dp)
                        )

                        Spacer(Modifier.padding(6.dp))
                        Text(
                            text = "24.5"
                        )

                        Spacer(Modifier.padding(4.dp))

                        Text(
                            text = "IMC NORMAL", textAlign = TextAlign.Center
                        )

                    }
                }
            }


            // IMC
            Card(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth()     // Que ocupe todoo lo que pueda respecto al weight
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .align(Alignment.CenterEnd)
                            .padding(top = 10.dp, bottom = 10.dp),    // Un pco de margen tanto arriba como abajo
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.corazonicono),
                            contentDescription = "FIcono Corazon",
                            modifier = Modifier.size(50.dp)
                        )

                        Spacer(Modifier.padding(6.dp))
                        Text(
                            text = "24.5"
                        )

                        Spacer(Modifier.padding(4.dp))

                        Text(
                            text = "IMC NORMAL", textAlign = TextAlign.Center
                        )

                    }
                }
            }
        }
    }


}

@Composable
fun MedidasYObjetivos() {
    Column(
        modifier = Modifier.fillMaxWidth(0.9f),    // Para que sea igual de ancho que la tarjetas de arriba (IMC, KCAL, AGUA)
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "MI CUERPO Y OBJETIVO", modifier = Modifier.align(Alignment.Start)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Peso
                    Row(
                        modifier = Modifier.fillMaxWidth(0.9f), // Para que no toque la card
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Fecha de registro",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Peso Actual"
                            )
                        }

                        // Icono y texto DER
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {

                            Text(
                                text = "80 kg"
                            )

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "Fecha de registro",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )

                        }
                    }

                    HorizontalDivider(thickness = 2.dp)


                    // Objetivo
                    Row(
                        modifier = Modifier.fillMaxWidth(0.9f), // Para que no toque la card
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Fecha de registro",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Objetivo"
                            )
                        }

                        // Icono y texto DER
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {

                            Text(
                                text = "80 kg"
                            )

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "Fecha de registro",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )

                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPerfil() {
    Perfil()
}