package com.example.nextreptfc.Modelo.Modelos

import androidx.annotation.DrawableRes

/*
    Esta dataclass unicamente sirve para la pantalla de bienvenida,
    hay que añadir la anotación @DrawableRes para que sepa la interfaz
    que es una imagen
 */
data class CardCarrousel(
    @DrawableRes val imagen: Int,
    val parrafoPrimario : String = "",
    val parrafoSecundario : String = "",
    val numero : Int = 0
)