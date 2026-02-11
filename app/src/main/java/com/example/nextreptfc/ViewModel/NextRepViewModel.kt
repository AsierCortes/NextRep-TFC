package com.example.nextreptfc.ViewModel

import androidx.lifecycle.ViewModel
import com.example.nextreptfc.Modelo.CardCarrousel
import com.example.nextreptfc.Modelo.ModeloNextRep
import com.example.nextreptfc.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NextRepViewModel : ViewModel(){
    private val privateModelo = MutableStateFlow(ModeloNextRep())
    val publicModelo = privateModelo.asStateFlow()

    // Para cargar antes la info
    init {
        crearCardsBienvenida()
    }

    // Métodoo que crea las cards de bienvenida
    fun crearCardsBienvenida(){
        val cards : List <CardCarrousel> = listOf(
            CardCarrousel(
                imagen = R.drawable.img1, // Pon tus imágenes aquí
                parrafoPrimario = "Estadísticas de precisión",
                parrafoSecundario = "Transforma tus datos en decisiones y mejora tu estrategia."
            ),
            CardCarrousel(
                imagen = R.drawable.img2,
                parrafoPrimario = "Tu diario deportivo",
                parrafoSecundario = "Registra y consulta el historial de todas tus sesiones al instante."
            ),
            CardCarrousel(
                imagen = R.drawable.img3,
                parrafoPrimario = "Rompe tus límites",
                parrafoSecundario = "Visualiza tu evolución histórica y alcanza tu máximo nivel."
            )
        )


        privateModelo.update {
            it.copy(
                listaCardsBienvenida = cards
            )
        }
    }


}