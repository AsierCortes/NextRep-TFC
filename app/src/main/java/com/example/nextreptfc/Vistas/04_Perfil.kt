package com.example.nextreptfc.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
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

    var editarPeso by remember { mutableStateOf(false) }
    var mostrarInfoPeso by remember { mutableStateOf(false) }

    var editarAltura by remember { mutableStateOf(false) }
    var mostrarInfoAltura by remember { mutableStateOf(false) }

    var editarGeneroYEdad by remember { mutableStateOf(false) }
    var mostrarInfoGeneroYEdad by remember { mutableStateOf(false) }

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
            MedidasYObjetivos(
                editarPeso = { editarPeso = true },
                editarAltura = { editarAltura = true },
                editarGeneroYEdad = { editarGeneroYEdad = true }
            )
            CuentaYAjustes()
            ZonaPeligrosa()
        }

    }
    // PESO
    // Ponemos el dialog fuera de la columna por limpieza
    if (editarPeso) {
        DialogPeso(
            pulsarFuera = { editarPeso = false },
            guardarPeso = { pesoActualizado ->
                println("Peso guardado: $pesoActualizado")
            },
            infoPesoPulsado = { mostrarInfoPeso = true }
        )
    }
    if (mostrarInfoPeso) {
        DialogInfoPeso(salirInfoPeso = { mostrarInfoPeso = false })
    }


    // ALTURA
    if (editarAltura) {
        DialogAltura(
            pulsarFuera = { editarAltura = false },
            guardarAltura = { alturaActualizada ->
                println("Altura guardada: $alturaActualizada")
            },
            infoAlturaPulsado = { mostrarInfoAltura = true }
        )
    }
    if (mostrarInfoAltura) {
        DialogInfoAltura(
            salirInfoAltura = { mostrarInfoAltura = false }
        )
    }

    // GÉNERO Y EDAD
    if (editarGeneroYEdad) {
        DialogGeneroYEdad(
            pulsarFuera = { editarGeneroYEdad = false },
            infoGeneroYEdad = {},
            guardarGeneroYAltura = { genero, edad ->
                println("Genero y edad guardados: $genero, $edad")
            }
        )
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
                    modifier = Modifier
                        .fillMaxWidth(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp)    // Un poco de espacio entre nombre y nombre usuario
                ) {

                    // Nombre y apelldio
                    Text(
                        text = "Asier Cortés",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        // Nombre Usuario
                        Text(
                            text = "@Asier.578"
                        )
                        Spacer(Modifier.padding(5.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.lapizeditar),
                            contentDescription = "editarnombreusuario",
                            modifier = Modifier.size(20.dp)
                        )
                    }

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
                            .padding(
                                top = 10.dp,
                                bottom = 10.dp
                            ),    // Un pco de margen tanto arriba como abajo
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
                            fontWeight = FontWeight.Bold,
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
                            .padding(
                                top = 10.dp,
                                bottom = 10.dp
                            ),    // Un pco de margen tanto arriba como abajo
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
                            fontWeight = FontWeight.Bold,
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
                            .padding(
                                top = 10.dp,
                                bottom = 10.dp
                            ),    // Un pco de margen tanto arriba como abajo
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
                            fontWeight = FontWeight.Bold,
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
fun MedidasYObjetivos(
    editarPeso: () -> Unit,
    editarAltura: () -> Unit,
    editarGeneroYEdad: () -> Unit,

    ) {
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
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                println("Editar Peso Actual")
                                editarPeso()
                            },
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
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                println("Editar Objetivo")
                            },
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
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                println("Editar Actividad")
                            },
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
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                println("Editar Altura")
                                editarAltura()
                            },
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
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                editarGeneroYEdad()
                                println("Editar Sexo y edad ")
                            },
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
                                text = "Sexo / Edad",
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
fun CuentaYAjustes() {
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
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                println("Editar Unidades")
                            },
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
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                println("Cambiar contraseña")
                            },
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
fun ZonaPeligrosa() {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f),    // Para que sea igual de ancho que la tarjetas de arriba (IMC, KCAL, AGUA)
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {

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


                    // Cerrar Sesión
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.cerrarsesion),
                            contentDescription = "cerrar sesion",
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.padding(5.dp))
                        Text(
                            text = "Cerrar Sesión",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.titleMedium
                        )

                    }

                    HorizontalDivider(thickness = 2.dp)

                    // Eliminar cuenta
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.papelera),
                            contentDescription = "papelera",
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.padding(5.dp))

                        Text(
                            text = "Eliminar Cuenta",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.titleMedium
                        )

                    }

                }
            }
        }
    }
}


/*
    DialoPeso
        -> Dialog
            -> Card  En este caso no va haber box por que no lo vamos a centrar verticalmente
               -> Column (fillMaxWidht, y le damos 20 de padding)
                        ->Row(fillMaxWidht)
                            -> Text (Introducir Peso)
                            -> Icono (Icono estilo info)
                        -> TextField
                        -> Row (fillMaxWidht)
                            -> Button (Guardar)
                            -> Button (Cancelar)
 */
@Composable
fun DialogPeso(
    pulsarFuera: () -> Unit,
    guardarPeso: (String) -> Unit,
    infoPesoPulsado: () -> Unit,
) {
    var pesoInput by remember { mutableStateOf("") }
    Dialog(
        onDismissRequest = { pulsarFuera() }    // Cuando pulsa fuera de la card
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),    // Ya se centra y no toca la card
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                // Titulo e icono
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Introducir Peso",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    IconButton(     //https://developer.android.com/develop/ui/compose/components/icon-button
                        onClick = { infoPesoPulsado() }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Info",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }

                // Textfield
                OutlinedTextField(
                    value = pesoInput,
                    onValueChange = { pesoInput = it },
                    label = { Text("Peso actual") },
                    placeholder = { Text("Ej: 75.5") },
                    suffix = { Text("kg") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),  // Unicamente permitimos teclado de tipo numérico
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                        cursorColor = MaterialTheme.colorScheme.primary,        // Cursor (Barra)
                        focusedLabelColor = MaterialTheme.colorScheme.primary   // Color label
                    )
                )

                // Botones
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    // Guardar
                    Button(
                        onClick = { guardarPeso(pesoInput) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Guardar",
                            color = Color.White
                        )
                    }

                    Spacer(Modifier.padding(10.dp))
                    // Cancelar
                    Button(
                        onClick = { pulsarFuera() },    // es considerado como pulsar fuera
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Cancelar",
                            color = Color.White
                        )
                    }


                }
            }

        }
    }
}


@Composable
fun DialogAltura(
    pulsarFuera: () -> Unit,
    guardarAltura: (String) -> Unit,
    infoAlturaPulsado: () -> Unit,

    ) {
    var alturaInput by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = { pulsarFuera() }    // Para salir
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),    // Ya se centra y no toca la card
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                // Titulo e icono
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Introducir Altura",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    IconButton(     //https://developer.android.com/develop/ui/compose/components/icon-button
                        onClick = { infoAlturaPulsado() }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Info",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .size(26.dp)
                        )
                    }
                }

                // Textfield
                OutlinedTextField(
                    value = alturaInput,
                    onValueChange = { alturaInput = it },
                    label = { Text("Altura actual") },
                    placeholder = { Text("Ej: 1.75") },
                    suffix = { Text("cm") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),  // Unicamente permitimos teclado de tipo numérico
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                        cursorColor = MaterialTheme.colorScheme.primary,        // Cursor (Barra)
                        focusedLabelColor = MaterialTheme.colorScheme.primary   // Color label
                    )
                )

                // Botones
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    // Guardar
                    Button(
                        onClick = { guardarAltura(alturaInput) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Guardar",
                            color = Color.White
                        )
                    }

                    Spacer(Modifier.padding(10.dp))
                    // Cancelar
                    Button(
                        onClick = { pulsarFuera() },    // Para salir
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Cancelar",
                            color = Color.White
                        )
                    }


                }
            }

        }
    }
}


@Composable
fun DialogGeneroYEdad(
    pulsarFuera: () -> Unit,
    infoGeneroYEdad: () -> Unit,
    guardarGeneroYAltura: (String, Int) -> Unit,
) {
    val generos = listOf("Masculino", "Femenino")
    val (opcionSeleccionada, gestionarOpcionSeleccionada) = remember { mutableStateOf(generos[0]) }     // Empieza con Masculino seleccionado
    var inputEdad by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = { pulsarFuera() }    // Para salir
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),    // Ya se centra y no toca la card
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                // Titulo e icono
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Género y Edad",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    IconButton(     //https://developer.android.com/develop/ui/compose/components/icon-button
                        onClick = { infoGeneroYEdad() }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Info",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .size(26.dp)
                        )
                    }
                }

                // Radio Options: https://developer.android.com/develop/ui/compose/components/radio-button

                /*
                    Esto se considera declaración de desestructurada, basicamente el opcionSeleccionada es el String, y
                    gestionarOpcionSeleccionada es una lambda que se encarga de cambiar el valor de la variable opcionSeleccionada
                    dependiendo si el usuario ha pulsado una u otra opción.
                 */
                // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior

                // Genero
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectableGroup(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    generos.forEach { text ->
                        // se selecciona la row y se repinta la pantalla, pareciendo que has pulsado el radiobutton
                        Row(
                            Modifier
                                .height(56.dp)
                                .selectable(
                                    selected = (text == opcionSeleccionada),
                                    onClick = { gestionarOpcionSeleccionada(text) },    // justo aqui esta la lambda
                                    role = Role.RadioButton
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            RadioButton(
                                selected = (text == opcionSeleccionada),  // Si el texto es igual a opcionesSeleccionada este se pone en true
                                onClick = null // null recommended for accessibility with screen readers
                            )
                            // Texto: (Masculino o femenino)
                            Text(
                                text = text,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )


                        }
                    }
                }

                // EDAD
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Edad:",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.titleMedium
                    )

                    // INPUT edad
                    OutlinedTextField(
                        value = inputEdad,
                        onValueChange = { valorIntroducido ->
                            /*
                                Con el .all es una lambda que recorre cada caracter del string, y comprueba que
                                todos ellos sean digitos, si todos ellos son dígitos y además no supera la longuitud de 3
                                entonces (999). Y el número tiene que ser menos o igual que 125 (humano mas longevo 122)
                             */
                            if (valorIntroducido.all { cadaValor -> cadaValor.isDigit() } && valorIntroducido.length <= 3 && valorIntroducido.toInt() <= 125) {
                                inputEdad = valorIntroducido
                            } else {
                                println("Edad introducida no valida")
                            }
                        },
                        label = { Text("Edad actual") },
                        placeholder = { Text("Ej: 20") },
                        suffix = { Text("años") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),  // Unicamente permitimos teclado de tipo numérico
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                            cursorColor = MaterialTheme.colorScheme.primary,        // Cursor (Barra)
                            focusedLabelColor = MaterialTheme.colorScheme.primary   // Color label
                        )
                    )


                }


                // Botones
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    // Guardar
                    Button(
                        onClick = { guardarGeneroYAltura(opcionSeleccionada, 0) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Guardar",
                            color = Color.White
                        )
                    }

                    Spacer(Modifier.padding(10.dp))
                    // Cancelar
                    Button(
                        onClick = { pulsarFuera() },    // Para salir
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Cancelar",
                            color = Color.White
                        )
                    }


                }
            }

        }
    }

}


@Composable
fun DialogInfoPeso(salirInfoPeso: () -> Unit) {
    Dialog(
        onDismissRequest = { salirInfoPeso() }
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "Info",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(26.dp)
                )

                Text(
                    text = "¿Por que necesitamos este dato?",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.titleLarge

                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Tu peso corporal es un dato necesario para poder sacar los siguientes datos:",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Justify
                    )

                    Text(
                        text = "• Calcular tus Calorías de Mantenimiento.\n" +
                                "• Ajustar tus gramos de proteína.\n" +
                                "• Definir tu hidratación ideal.\n\n" +
                                "Es solo un dato matemático para calibrar tu plan.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.titleMedium
                    )
                }


                Button(
                    onClick = { salirInfoPeso() },     // Cuando pulse aqui saldrá del dialog informativo
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Continuar"
                    )
                }


            }
        }
    }
}

@Composable
fun DialogInfoAltura(salirInfoAltura: () -> Unit) {
    Dialog(
        onDismissRequest = { salirInfoAltura() }
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "Info",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(26.dp)
                )

                Text(
                    text = "¿Por que necesitamos este dato?",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.titleLarge

                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Tu altura aporta el contexto necesario para que los cálculos sean precisos:",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "• Índice de Masa Corporal (IMC): El peso por sí solo es un dato incompleto. Al cruzarlo con tu altura, " +
                                "calculamos tu IMC para saber si te encuentras en un rango saludable.\n \n" +
                                "• Gasto Calórico: La altura influye directamente en tu metabolismo basal. Un cuerpo más grande consume " +
                                "más energía en reposo, y necesitamos este dato para no darte menos comida de la que necesitas.\n \n" +
                                "• Objetivos Reales: Nos permite sugerirte un peso objetivo que sea realista y sostenible para tu estructura física.\n",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Justify
                    )
                }


                Button(
                    onClick = { salirInfoAltura() },     // Cuando pulse aqui saldrá del dialog informativo
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Continuar"
                    )
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