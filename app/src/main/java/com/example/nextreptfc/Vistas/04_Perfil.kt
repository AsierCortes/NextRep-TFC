package com.example.nextreptfc.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(state),     // Para que sea scrolleable

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            CardSuperiorFoto()
            DatosCalculados()
            MedidasYObjetivos()
            CuentaYAjustes()
        }

    }
}

@Composable
fun CardSuperiorFoto() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                // Foto de Perfil
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.deku),
                        contentDescription = "Foto de perfil ejemplo",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                // Nombre, apellido y Nombre usuario
                Column(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp)    // Un poco de espacio entre nombre y nombre usuario
                ) {

                    // Nombre y apelldio
                    Text(
                        text = "Asier Cortés",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold
                    )

                    // Nombre Usuario
                    Text(
                        text = "@Asier.578"
                    )
                }

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

                            Text(
                                text = "Miembro desde 2024", textAlign = TextAlign.Center
                            )

                        }
                    }
                }
            }

        }
    }
}


@Composable
fun DatosCalculados() {

    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        // IMC; KCAL Y AGUA
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {


            // IMC
            Card(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth(),     // Que ocupe todoo lo que pueda respecto al weight
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(top = 10.dp, bottom = 10.dp),    // Un pco de margen tanto arriba como abajo
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.corazon),
                            contentDescription = "FIcono Corazon",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Red
                        )

                        Text(
                            text = "24.5",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )


                        Text(
                            text = "IMC NORMAL",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                    }
                }
            }

            // IMC
            Card(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth(),     // Que ocupe todoo lo que pueda respecto al weight
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(top = 10.dp, bottom = 10.dp),    // Un pco de margen tanto arriba como abajo
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.fuego),
                            contentDescription = "FIcono Corazon",
                            modifier = Modifier.size(32.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            text = "2400",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )


                        Text(
                            text = "KCAL META",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                    }
                }
            }


            // IMC
            Card(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth(),     // Que ocupe todoo lo que pueda respecto al weight
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(top = 10.dp, bottom = 10.dp),    // Un pco de margen tanto arriba como abajo
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.gotadeagua),
                            contentDescription = "FIcono Corazon",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Blue

                            )

                        Text(
                            text = "2.5L",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )


                        Text(
                            text = "AGUA",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
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
        modifier = Modifier
            .fillMaxWidth(0.9f),    // Para que sea igual de ancho que la tarjetas de arriba (IMC, KCAL, AGUA)
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        Text(
            text = "MI CUERPO Y OBJETIVO",
            modifier = Modifier.align(Alignment.Start)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Peso
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),  // Un poco de espacio entre el icono y el text

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.bascula),
                                contentDescription = "peso",
                                modifier = Modifier.size(26.dp)
                            )
                            Text(
                                text = "Peso Actual",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        // Icono y texto DER
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {

                            Text(
                                text = "80 kg",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "Fecha de registro",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )

                        }
                    }

                    HorizontalDivider(thickness = 2.dp)     // https://developer.android.com/develop/ui/compose/components/divider

                    // Peso
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),  // Un poco de espacio entre el icono y el text

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.objetivo),
                                contentDescription = "objetivos",
                                modifier = Modifier.size(26.dp)
                            )
                            Text(
                                text = "Objetivo",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        // Icono y texto DER
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {

                            Text(
                                text = "Ganar Fuerza",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
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

                    // Peso
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),  // Un poco de espacio entre el icono y el text

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.actividad),
                                contentDescription = "actividad",
                                modifier = Modifier.size(26.dp)
                            )
                            Text(
                                text = "Actividad",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        // Icono y texto DER
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {

                            Text(
                                text = "Moderado (3-5 días)",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
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

                    // Peso
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),  // Un poco de espacio entre el icono y el text

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.altura),
                                contentDescription = "Fecha de registro",
                                modifier = Modifier.size(26.dp)
                            )
                            Text(
                                text = "Altura",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        // Icono y texto DER
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {

                            Text(
                                text = "180 cm",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
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

                    // Peso
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),  // Un poco de espacio entre el icono y el text

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.genero),
                                contentDescription = "genero",
                                modifier = Modifier.size(26.dp)
                            )
                            Text(
                                text = "Sexo / Género",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        // Icono y texto DER
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {

                            Text(
                                text = "Hombre, 25",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
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

@Composable
fun CuentaYAjustes(){
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f),    // Para que sea igual de ancho que la tarjetas de arriba (IMC, KCAL, AGUA)
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        Text(
            text = "CUENTAS Y AJUSTES",
            modifier = Modifier.align(Alignment.Start)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Correo
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),  // Un poco de espacio entre el icono y el text

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.correo),
                                contentDescription = "correo",
                                modifier = Modifier.size(26.dp)
                            )
                            Text(
                                text = "Correo",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        // EMAIL
                        Text(
                            text = "asier.cortes@gmail.com",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    HorizontalDivider(thickness = 2.dp)     // https://developer.android.com/develop/ui/compose/components/divider

                    // Vinculada con
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),  // Un poco de espacio entre el icono y el text

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.enlace),
                                contentDescription = "enlace",
                                modifier = Modifier.size(26.dp)
                            )
                            Text(
                                text = "Vinculada con",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        // ICONO
                        Icon(
                            painter = painterResource(id = R.drawable.google_icon),
                            contentDescription = "google",
                            modifier = Modifier.size(26.dp)
                        )
                    }

                    HorizontalDivider(thickness = 2.dp)

                    // Unidades
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),  // Un poco de espacio entre el icono y el text

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.medidas),
                                contentDescription = "unidades",
                                modifier = Modifier.size(26.dp)
                            )
                            Text(
                                text = "Unidades",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        // Icono y texto DER
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {

                            Text(
                                text = "Métrico (Kg/Cm)",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "Flecha der",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )

                        }
                    }

                    HorizontalDivider(thickness = 2.dp)

                    // Peso
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween    // Para que cada row este en una esquina
                    ) {

                        // Icono y texto IZQ
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp),  // Un poco de espacio entre el icono y el text

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.candado),
                                contentDescription = "candado",
                                modifier = Modifier.size(26.dp)
                            )
                            Text(
                                text = "Cambiar Contraseña",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        // Icono y texto DER
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)  // Un poco de espacio entre el icono y el text
                        ) {

                            Text(
                                text = "180 cm",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
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

@Composable
fun ZonaPeligrosa(){

}

@Preview
@Composable
fun PreviewPerfil() {
    Perfil()
}