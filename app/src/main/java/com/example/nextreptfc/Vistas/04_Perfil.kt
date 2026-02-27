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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.nextreptfc.Modelo.Modelos.NivelActividad
import com.example.nextreptfc.Modelo.Modelos.ObjetivoFisico
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

    // Variables que se encargan de pintar los distintos dialogs

    var editarNickName by remember { mutableStateOf(false) }
    var mostrarInfoNickName by remember { mutableStateOf(false) }

    var editarPeso by remember { mutableStateOf(false) }
    var mostrarInfoPeso by remember { mutableStateOf(false) }

    var editarAltura by remember { mutableStateOf(false) }
    var mostrarInfoAltura by remember { mutableStateOf(false) }

    var editarGeneroYEdad by remember { mutableStateOf(false) }
    var mostrarInfoGeneroYEdad by remember { mutableStateOf(false) }

    var editarUnidadesMetricas by remember { mutableStateOf(false) }
    var mostrarInfoUnidades by remember { mutableStateOf(false) }

    var editarNivelActividad by remember { mutableStateOf(false) }
    var mostrarInfoNivelActividad by remember { mutableStateOf(false) }

    var editarObjetivoFisico by remember { mutableStateOf(false) }
    var mostrarInfoObjetivoFisico by remember { mutableStateOf(false) }

    var editarContrasena by remember { mutableStateOf(false) }
    var cerrarSesion by remember { mutableStateOf(false) }
    var eliminarCuenta by remember { mutableStateOf(false) }
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
            CardSuperiorFoto(
                editarNickName = {editarNickName = true}
            )
            DatosCalculados()
            MedidasYObjetivos(
                editarPeso = { editarPeso = true },
                editarAltura = { editarAltura = true },
                editarGeneroYEdad = { editarGeneroYEdad = true },
                editarNivelActividad = {editarNivelActividad = true},
                editarObjetivoFisico = {editarObjetivoFisico = true}
            )
            CuentaYAjustes(
                editarUnidadesMetricas = {editarUnidadesMetricas = true},
                editarContrasena = {editarContrasena = true}
            )
            ZonaPeligrosa(
                cerrarSesion = {cerrarSesion = true},
                eliminarCuenta = {eliminarCuenta = true}
            )
        }

    }

    // NICKNAME
    if(editarNickName){
        DialogCambiarNickname(
            pulsarFuera = {editarNickName = false},
            guardarNickname = {nickname ->
                println("Nuevo nickname: $nickname")
            },
            infoNicknamePulsado = {} // Ns si implementarlo
        ) 
    }


    // PESO
    // Ponemos el dialog fuera de la columna por limpieza
    if (editarPeso) {
        DialogPeso(
            pulsarFuera = { editarPeso = false },
            guardarPeso = { pesoActualizado ->
                println("Peso guardado: $pesoActualizado");
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
            infoGeneroYEdad = {mostrarInfoGeneroYEdad = true},
            guardarGeneroYAltura = { genero, edad ->
                println("Genero y edad guardados: $genero, $edad")
            }
        )
    }
    if(mostrarInfoGeneroYEdad){
        DialogInfoGeneroYEdad(
            salirInfoGeneroYEdad = {mostrarInfoGeneroYEdad = false}
        )
    }

    // UNIDADES MÉTRICA
    if(editarUnidadesMetricas){
        DialogUnidades(
            pulsarFuera = { editarUnidadesMetricas = false },
            infoUnidades = { mostrarInfoUnidades = true },
            guardarUnidades = { println("Unidades guardadas: $it") }
        ) 
    }
    if(mostrarInfoUnidades){
        DialogInfoUnidades(
            salirInfoUnidades = { mostrarInfoUnidades = false }
        )
    }

    // NIVEL ACTIVIDAD
    if(editarNivelActividad){
        DialogNivelActividad(
            pulsarFuera = {editarNivelActividad = false},
            infoActividad = {mostrarInfoNivelActividad = true},
            guardarActividad = {println("Nivel de actividad seleccionado: $it. Multiplicador: ${it.multiplicador}")}
        )
    }
    if(mostrarInfoNivelActividad){
        DialogInfoNivelActividad(
            salirInfoActividad = { mostrarInfoNivelActividad = false }
        )
    }


    // OBJETIVO FÍSICO
    if(editarObjetivoFisico){
        DialogObjetivoFisico(
            pulsarFuera = {editarObjetivoFisico = false},
            infoObjetivo = {mostrarInfoObjetivoFisico = true},
            guardarObjetivo = {
                println("Objetivo seleccionado $it")
            }
        )
    }
    if(mostrarInfoObjetivoFisico){
        DialogInfoObjetivoFisico(
            salirInfoObjetivo = { mostrarInfoObjetivoFisico = false }
        ) 
    }

    // CERRAR SESIÓN
    if(cerrarSesion){
        DialogCerrarSesion(
            pulsarFuera = { cerrarSesion = false },
            cerrarSesionConfirmado = { println("Cerrar Sesión Confirmado") }  // Implementar
        )
    }
    // ELIMINAR CUENTA
    if(eliminarCuenta){
        DialogEliminarCuenta(
            pulsarFuera = {eliminarCuenta = false},
            eliminarCuentaConfirmado = { println("Se va a proceder a eliminar la cuenta") }
        ) 
    }

    // EDITAR CONTRASEÑA
    if(editarContrasena){
        DialogCambiarContrasenia(
            pulsarFuera = {editarContrasena = false},
            guardarNuevaContrasenia = { contrasena ->
                println("Contraseña nueva: $contrasena")
            }
        )
    }

}

@Composable
fun CardSuperiorFoto(
    editarNickName : () -> Unit
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
                        IconButton(
                            onClick = {
                                editarNickName()    // Funcion lambda cambiar nombre
                                println("Cambiar nombre usuario")
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.lapizeditar),
                                contentDescription = "editarnombreusuario",
                                modifier = Modifier.size(20.dp)
                            )
                        }
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
    editarNivelActividad: () -> Unit,
    editarObjetivoFisico : () -> Unit

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
                                editarObjetivoFisico()
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
                                editarNivelActividad()
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
fun CuentaYAjustes(
    editarUnidadesMetricas : () -> Unit,
    editarContrasena : () -> Unit
) {
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
                                editarUnidadesMetricas()
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

                        // Icono der flecha
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Flecha der",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )


                    }

                    HorizontalDivider(thickness = 2.dp)

                    // Peso
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // Para que no toque la card
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                println("Cambiar contraseña")
                                editarContrasena()
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
fun ZonaPeligrosa(
    cerrarSesion : () -> Unit,
    eliminarCuenta : () -> Unit
) {
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
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                println("Cerrar Sesión")
                                cerrarSesion()
                            },
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
                            .padding(top = 10.dp, bottom = 10.dp)
                            .clickable {
                                println("Eliminar Cuenta")
                                eliminarCuenta()
                            },
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
                        onClick = { guardarPeso(pesoInput); pulsarFuera() },
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
                        onClick = { guardarAltura(alturaInput); pulsarFuera() },
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
    guardarGeneroYAltura: (String, String) -> Unit,
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
                        onClick = { guardarGeneroYAltura(opcionSeleccionada, inputEdad); pulsarFuera() },
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
fun DialogUnidades(
    pulsarFuera: () -> Unit,
    infoUnidades: () -> Unit,
    guardarUnidades: (String) -> Unit,
) {
    val sistemas = listOf("Métrico (kg, cm, L)", "Imperial (lbs, in, gal)")
    val (opcionSeleccionada, gestionarOpcionSeleccionada) = remember { mutableStateOf(sistemas[0]) } // Empieza con Métrico

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
                        text = "Sistema de Unidades",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    IconButton(
                        onClick = { infoUnidades() }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Info Unidades",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }

                // Radio Options
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectableGroup(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    sistemas.forEach { text ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .selectable(
                                    selected = (text == opcionSeleccionada),
                                    onClick = { gestionarOpcionSeleccionada(text) },
                                    role = Role.RadioButton
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            RadioButton(
                                selected = (text == opcionSeleccionada),
                                onClick = null
                            )
                            Text(
                                text = text,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }

                // Botones
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)   // Un poco de espacio entre el btn y el texto
                ) {
                    // Guardar
                    Button(
                        onClick = { guardarUnidades(opcionSeleccionada); pulsarFuera() },
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

                    // Cancelar
                    Button(
                        onClick = { pulsarFuera() },
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
fun DialogNivelActividad(
    pulsarFuera: () -> Unit,
    infoActividad: () -> Unit,
    guardarActividad: (NivelActividad) -> Unit
) {
    // Iniciamos con Sedentario por defecto
    val (opcionSeleccionada, gestionarOpcionSeleccionada) = remember { mutableStateOf(NivelActividad.SEDENTARIO) }

    Dialog(
        onDismissRequest = { pulsarFuera() }
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
                verticalArrangement = Arrangement.spacedBy(20.dp), // Espaciado general
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // HEADER: Título e Icono Info
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Nivel de Actividad",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    IconButton(onClick = { infoActividad() }) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Info",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }

                // LISTA DE OPCIONES (RadioButtons)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectableGroup(),
                    verticalArrangement = Arrangement.spacedBy(18.dp) // Separación entre opciones
                ) {
                    // Recorremos el Enum
                    NivelActividad.entries.forEach { nivel ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (nivel == opcionSeleccionada),
                                    onClick = { gestionarOpcionSeleccionada(nivel) },
                                    role = Role.RadioButton
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp) // Espacio entre RadioButton y Textos
                        ) {
                            // 1. El RadioButton
                            RadioButton(
                                selected = (nivel == opcionSeleccionada),
                                onClick = null // Null por accesibilidad (lo maneja el Row)
                            )

                            // La Columna con los dos Textos
                            Column(
                                verticalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                // Título
                                Text(
                                    text = nivel.titulo,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.SemiBold
                                )
                                // Descripción
                                Text(
                                    text = nivel.descripcion,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    style = MaterialTheme.typography.bodySmall,
                                    lineHeight = 16.sp
                                )
                            }
                        }
                    }
                }

                // BOTONES GUARDAR Y CANCELAR
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                ) {
                    // Botón Guardar
                    Button(
                        onClick = { guardarActividad(opcionSeleccionada); pulsarFuera() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Guardar", color = Color.White)
                    }

                    // Botón Cancelar
                    Button(
                        onClick = { pulsarFuera() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Cancelar", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun DialogObjetivoFisico(
    pulsarFuera: () -> Unit,
    infoObjetivo: () -> Unit,
    guardarObjetivo: (ObjetivoFisico) -> Unit
) {
    // Iniciamos con Mantenimiento por defecto (o el que prefieras)
    val (opcionSeleccionada, gestionarOpcionSeleccionada) = remember { mutableStateOf(ObjetivoFisico.MANTENIMIENTO) }

    Dialog(
        onDismissRequest = { pulsarFuera() }
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
                verticalArrangement = Arrangement.spacedBy(20.dp), // Espaciado general
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // HEADER: Título e Icono Info
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Objetivo Físico",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    IconButton(onClick = { infoObjetivo() }) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Info",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }

                // LISTA DE OPCIONES (RadioButtons)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectableGroup(),
                    verticalArrangement = Arrangement.spacedBy(18.dp) // Separación entre opciones
                ) {
                    // Recorremos el Enum de Objetivos
                    ObjetivoFisico.entries.forEach { objetivo ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (objetivo == opcionSeleccionada),
                                    onClick = { gestionarOpcionSeleccionada(objetivo) },
                                    role = Role.RadioButton
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp) // Espacio entre RadioButton y Textos
                        ) {
                            // 1. El RadioButton
                            RadioButton(
                                selected = (objetivo == opcionSeleccionada),
                                onClick = null // Null por accesibilidad (lo maneja el Row)
                            )

                            // La Columna con los dos Textos
                            Column(
                                verticalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                // Título
                                Text(
                                    text = objetivo.titulo,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.SemiBold
                                )
                                // Descripción
                                Text(
                                    text = objetivo.descripcion,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    style = MaterialTheme.typography.bodySmall,
                                    lineHeight = 16.sp
                                )
                            }
                        }
                    }
                }

                // BOTONES GUARDAR Y CANCELAR
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                ) {
                    // Botón Guardar
                    Button(
                        onClick = {
                            guardarObjetivo(opcionSeleccionada)
                            pulsarFuera()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Guardar", color = Color.White)
                    }

                    // Botón Cancelar
                    Button(
                        onClick = { pulsarFuera() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Cancelar", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun DialogCambiarNickname(
    pulsarFuera: () -> Unit,
    guardarNickname: (String) -> Unit,
    infoNicknamePulsado: () -> Unit,
) {
    var nicknameInput by remember { mutableStateOf("") }

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
                    // TÍTULO CAMBIADO
                    Text(
                        text = "Cambiar Nickname",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    IconButton(
                        onClick = { infoNicknamePulsado() }
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
                    value = nicknameInput,
                    onValueChange = { nicknameInput = it },
                    label = { Text("Nuevo NickName") },
                    placeholder = { Text("Ej: Asier.578") },
                    singleLine = true,
                    // Cambiado a KeyboardType.Text para permitir letras
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
                        onClick = { guardarNickname(nicknameInput); pulsarFuera() },
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
fun DialogCerrarSesion(
    pulsarFuera: () -> Unit,
    cerrarSesionConfirmado: () -> Unit
) {
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
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                // Título en color rojo (Error)
                Text(
                    text = "Cerrar Sesión",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.error // Aplicado el color que pediste
                )

                // Textos explicativos
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "¿Seguro que quieres cerrar sesión?",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Al cerrar sesión tendrás que volver a introducir tu correo electrónico y tu contraseña la próxima vez que quieras acceder a la aplicación.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }

                // Botones
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                ) {
                    // Botón Cerrar Sesión (Rojo/Error porque es destructivo)
                    Button(
                        onClick = {
                            cerrarSesionConfirmado()
                            pulsarFuera()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Cerrar Sesión",
                            color = Color.White
                        )
                    }

                    // Botón Cancelar (Primario porque es la opción "segura")
                    Button(
                        onClick = { pulsarFuera() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
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
fun DialogEliminarCuenta(
    pulsarFuera: () -> Unit,
    eliminarCuentaConfirmado: () -> Unit
) {
    // Estados para los TextFields
    var confirmacionInput by remember { mutableStateOf("") }
    var contrasenaInput by remember { mutableStateOf("") }
    var contrasenaOculta by remember { mutableStateOf(true) }

    Dialog(
        onDismissRequest = { pulsarFuera() }
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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                // Título en color rojo (Error)
                Text(
                    text = "Eliminar cuenta",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.error
                )

                // Textos explicativos
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "¿Seguro que quieres eliminar la cuenta?",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Esta acción es irreversible. Se eliminará tu cuenta y toda la información relacionada, como entrenamientos, ejercicios, medidas y objetivos.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }

                // Inputs de confirmación
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    // Input: Palabra de confirmación
                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(
                            text = "Introduce \"Eliminar\" para confirmar:",
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        OutlinedTextField(
                            value = confirmacionInput,
                            onValueChange = { confirmacionInput = it },
                            placeholder = { Text("Eliminar") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = MaterialTheme.colorScheme.error, // Rojo porque es una acción peligrosa
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                                cursorColor = MaterialTheme.colorScheme.error
                            )
                        )
                    }

                    // Input: Contraseña
                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(
                            text = "Contraseña:",
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        OutlinedTextField(
                            value = contrasenaInput,
                            onValueChange = { contrasenaInput = it },
                            placeholder = { Text("Tu contraseña") },
                            singleLine = true,

                            /*
                                Es una función de Android Jetpack Compose, te permite ocultar
                                el texto que esta en el input por un caracter. En este caso
                                esta puesto el predeterminado
                                Y VisualTranformation.None cambia el texto a visible
                             */

                            visualTransformation = if (contrasenaOculta){
                                PasswordVisualTransformation()
                            } else {
                                VisualTransformation.None
                            },
                            trailingIcon = {    // Se muestra al final del outlined
                                IconButton(onClick = { contrasenaOculta = !contrasenaOculta }) {
                                    Icon(
                                        painter = painterResource(id = if (contrasenaOculta){
                                            R.drawable.ojo
                                        }else {
                                            R.drawable.ojocerrado
                                        }),
                                        contentDescription = if (contrasenaOculta){
                                            "Mostrar contraseña"
                                        } else {
                                            "Ocultar contraseña"
                                               },
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = MaterialTheme.colorScheme.error,
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                                cursorColor = MaterialTheme.colorScheme.error
                            )
                        )
                    }
                }

                // Botones
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                ) {
                    // Botón Confirmar (Rojo)
                    Button(
                        onClick = {
                            eliminarCuentaConfirmado()
                            pulsarFuera()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Confirmar",
                            color = Color.White
                        )
                    }

                    // Botón Cancelar (Primario)
                    Button(
                        onClick = { pulsarFuera() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
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
fun DialogCambiarContrasenia(
    pulsarFuera: () -> Unit,
    guardarNuevaContrasenia: (String) -> Unit
) {
    // Estados para el campo de la Contraseña Actual
    var contrasenaActualInput by remember { mutableStateOf("") }
    var contrasenaActualOculta by remember { mutableStateOf(true) }

    // Estados para el campo de la Nueva Contraseña
    var contrasenaNuevaInput by remember { mutableStateOf("") }
    var contrasenaNuevaOculta by remember { mutableStateOf(true) }

    Dialog(
        onDismissRequest = { pulsarFuera() }
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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp) // Mismo espaciado general
            ) {

                // Título
                Text(
                    text = "Cambiar Contraseña",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Texto explicativo
                Text(
                    text = "Para cambiar de contraseña has de introducir la contraseña anterior y la nueva.",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )

                // Contenedor de los Inputs
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {

                    // Input 1: Contraseña Actual
                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(
                            text = "Contraseña Actual",
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        OutlinedTextField(
                            value = contrasenaActualInput,
                            onValueChange = { contrasenaActualInput = it },
                            placeholder = { Text("Tu contraseña actual") },
                            singleLine = true,
                            visualTransformation = if (contrasenaActualOculta){
                                PasswordVisualTransformation()
                            } else {
                                VisualTransformation.None
                            },
                            trailingIcon = {
                                IconButton(onClick = { contrasenaActualOculta = !contrasenaActualOculta }) {
                                    Icon(
                                        painter = painterResource(id = if (contrasenaActualOculta) {
                                            R.drawable.ojo
                                        } else {
                                            R.drawable.ojocerrado
                                        }),
                                        contentDescription = if (contrasenaActualOculta) {
                                            "Mostrar contraseña"
                                        } else {
                                            "Ocultar contraseña"
                                        },
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = MaterialTheme.colorScheme.primary,
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                                cursorColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }

                    // Input 2: Nueva Contraseña
                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(
                            text = "Nueva Contraseña",
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        OutlinedTextField(
                            value = contrasenaNuevaInput,
                            onValueChange = { contrasenaNuevaInput = it },
                            placeholder = { Text("Tu nueva contraseña") },
                            singleLine = true,
                            visualTransformation = if (contrasenaNuevaOculta){
                                PasswordVisualTransformation()
                            } else {
                                VisualTransformation.None
                            },
                            trailingIcon = {
                                IconButton(onClick = { contrasenaNuevaOculta = !contrasenaNuevaOculta }) {
                                    Icon(
                                        painter = painterResource(id = if (contrasenaNuevaOculta) {
                                            R.drawable.ojo
                                        } else {
                                            R.drawable.ojocerrado
                                        }),
                                        contentDescription = if (contrasenaNuevaOculta) {
                                            "Mostrar contraseña"
                                        } else {
                                            "Ocultar contraseña"
                                        },
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = MaterialTheme.colorScheme.primary,
                                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                                cursorColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }

                // Botones
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                ) {
                    // Botón Confirmar
                    Button(
                        onClick = {
                            guardarNuevaContrasenia(contrasenaNuevaInput)
                            pulsarFuera()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Confirmar",
                            color = Color.White
                        )
                    }

                    // Botón Cancelar
                    Button(
                        onClick = { pulsarFuera() },
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
                        text = "Continuar",
                        color = Color.White
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
                        style = MaterialTheme.typography.bodyMedium,
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
                        text = "Continuar",
                        color = Color.White
                    )
                }


            }
        }
    }
}

@Composable
fun DialogInfoGeneroYEdad(salirInfoGeneroYEdad:() -> Unit){
    Dialog(
        onDismissRequest = { salirInfoGeneroYEdad() }
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
                    text = "¿Por que necesitamos estos datos?",
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
                        text = "Necesitamos estos datos para ajustar ciertos parametros:",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "• Tasa Metabólica Basal (TMB): Las ecuaciones médicas usan tu edad y sexo biológico " +
                                "para determinar cuántas calorías quema tu cuerpo en reposo.\n \n" +
                                "• Frecuencia Cardíaca Máxima: Necesitamos tu edad para calcular el límite máximo de pulsaciones. " +
                                "Sin este parámetro, no podemos calcular tus zonas de esfuerzo.\n \n" +
                                "• Ajuste Hormonal: Hombres y mujeres tienen distintos porcentajes de grasa esencial y músculo, " +
                                "lo que altera el cálculo final de tus macronutrientes.\n",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }


                Button(
                    onClick = { salirInfoGeneroYEdad() },     // Cuando pulse aqui saldrá del dialog informativo
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Continuar",
                        color = Color.White
                    )
                }


            }
        }
    }

}

@Composable
fun DialogInfoUnidades(salirInfoUnidades: () -> Unit) {
    Dialog(
        onDismissRequest = { salirInfoUnidades() }
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
                    text = "Sistemas de Medida",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.titleLarge
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // SUBTÍTULO CAMBIADO
                    Text(
                        text = "Elige el estándar con el que te sientas más cómodo para registrar tus datos diarios:",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.titleMedium
                    )

                    // TEXTO EXPLICATIVO CAMBIADO CON LOS DOS SISTEMAS
                    Text(
                        text = "• Sistema Métrico: Es el estándar internacional. Utiliza Kilogramos (kg) para medir el peso corporal o los discos del gimnasio, Centímetros (cm) para la altura y Litros (L) para el consumo de agua.\n \n" +
                                "• Sistema Imperial: Es el formato tradicional utilizado en Estados Unidos. Utiliza Libras (lbs) para medir el peso, Pulgadas y Pies (in/ft) para la altura y Galones u Onzas líquidas (gal/fl oz) para los líquidos.\n \n" +
                                "Podrás cambiar esta configuración más adelante si lo necesitas.\n",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }

                Button(
                    onClick = { salirInfoUnidades() },     // Cuando pulse aqui saldrá del dialog informativo
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Continuar",
                        color = Color.White
                    )
                }

            }
        }
    }
}

@Composable
fun DialogInfoNivelActividad(salirInfoActividad: () -> Unit) {
    Dialog(
        onDismissRequest = { salirInfoActividad() }
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

                // TÍTULO CAMBIADO
                Text(
                    text = "Nivel de Actividad",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.titleLarge
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // SUBTÍTULO CAMBIADO (El "Por qué")
                    Text(
                        text = "El nivel de actividad es el 'Factor Multiplicador'. Necesitamos este dato para saber cuántas calorías reales quemas en tu día a día:",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Justify
                    )

                    // TEXTO EXPLICATIVO CAMBIADO (Los niveles y conclusión)
                    Text(
                        text = "• Sedentario: Trabajo de oficina o en el que pasas la mayor parte del tiempo sentado, sin ejercicio extra.\n \n" +
                                "• Ligeramente Activo: Caminas regularmente o haces ejercicio ligero de 1 a 3 días por semana.\n \n" +
                                "• Moderadamente Activo: Entrenamiento constante o deportes de intensidad media de 3 a 5 días por semana.\n \n" +
                                "• Muy Activo: Entrenamientos intensos de 6 a 7 días por semana o trabajos físicos.\n \n" +
                                "• Extremadamente Activo: Dobles sesiones de entrenamiento diarias o trabajos de alta exigencia física (ej. albañil).\n \n" +
                                "Elegir el nivel correcto asegura que no te falte ni te sobre energía en tu plan.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }

                Button(
                    onClick = { salirInfoActividad() },     // Cuando pulse aqui saldrá del dialog informativo
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Continuar",
                        color = Color.White
                    )
                }

            }
        }
    }
}

@Composable
fun DialogInfoObjetivoFisico(salirInfoObjetivo: () -> Unit) {
    Dialog(
        onDismissRequest = { salirInfoObjetivo() }
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
                    text = "Objetivo Físico",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.titleLarge
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Subtítulo neutro y directo
                    Text(
                        text = "El objetivo físico define la dirección del plan de entrenamiento y nutrición:",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Justify
                    )

                    // Definiciones objetivas
                    Text(
                        text = "• Perder Grasa: Consiste en reducir las reservas de grasa corporal manteniendo la mayor cantidad de masa muscular posible.\n \n" +
                                "• Ganar Músculo: Busca el crecimiento estético y el aumento del volumen muscular a través de un consumo de energía mayor al gastado.\n \n" +
                                "• Ganar Fuerza: Se centra en maximizar el peso levantado y el rendimiento físico general, sin priorizar el aumento de tamaño muscular.\n \n" +
                                "• Mantenimiento: Consiste en mantener un equilibrio energético exacto. Es ideal para estabilizar el peso actual o para buscar una mejora gradual siendo principiante.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }

                Button(
                    onClick = { salirInfoObjetivo() },     // Cuando pulse aqui saldrá del dialog informativo
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Continuar",
                        color = Color.White
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