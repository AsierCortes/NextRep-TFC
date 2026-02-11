package com.example.nextreptfc.Vistas

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nextreptfc.Modelo.CardCarrousel
import com.example.nextreptfc.R
import com.example.nextreptfc.ViewModel.NextRepViewModel
import com.example.nextreptfc.ui.theme.LightSurface


/*
    Estructura:
    Column (Centra todoo)
        -> Card (Ocupa casi todoo)
               -> Column (Ocupa todoo)
                   -> Box   Metemos la imagen dentro de una box para que así no se salga. Lo utilizamos como marco
                        -> Img
                   -> Column
                        -> Puntos carrousel
                        -> Column
                            -> Text
                            -> Text
                        -> Button

    Para que el weight funcione correctamente el padre debe ser obligatoriamente una column o row
 */
@Composable
fun Bienvenida(controller: NextRepViewModel = viewModel()) {
    val publicModel = controller.publicModelo.collectAsState()
    val listaCards : List<CardCarrousel> = publicModel.value.listaCardsBienvenida

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(0.9f)
        ){
            CarrouselCards(listaCards)
        }


    }
}
// Me he basado en el siguiente ejemplo: https://proandroiddev.com/swipeable-image-carousel-with-smooth-animations-in-jetpack-compose-76eacdc89bfb
@Composable
fun CarrouselCards(listaCards : List <CardCarrousel>){

    val paginadorCards = rememberPagerState { listaCards.size }

    HorizontalPager(
        state = paginadorCards,
        modifier = Modifier.fillMaxWidth(),
    ) { numCardActual ->


        // Las card para cambiar el colo de fondo utilizamos el atributo Colors, no el Modifier.background
        Card(
            modifier = Modifier
                .fillMaxSize(),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),

            ) {


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .weight(0.5f)       // 1. La Box reserva el 50% del espacio OBLIGATORIAMENTE
                        .fillMaxWidth(0.9f)
                        .padding(top = 10.dp)
                ) {
                    Image(
                        painter = painterResource(listaCards[numCardActual].imagen),
                        contentDescription = "Fotos carrousel",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = listaCards[numCardActual].parrafoPrimario,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth(0.9f)

                        )

                        Text(
                            text = listaCards[numCardActual].parrafoSecundario,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                        )

                    }

                    Spacer(Modifier.padding(20.dp))

                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(6.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 6.dp,    // En reposo la sombra es de 6.dp
                            pressedElevation = 2.dp     // Cuando pulsas la sombre pasa a 2.dp
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                    ) {
                        Text(
                            text = "EMPEZAR AHORA >",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,     // Tanto en modo claro como oscuro esta este texto en blanco
                            modifier = Modifier
                                .padding(top = 4.dp, bottom = 4.dp)
                        )
                    }


                }
            }
        }
    }
}



@Composable
@Preview
fun PreviewBienvenida() {
    Bienvenida()
}
