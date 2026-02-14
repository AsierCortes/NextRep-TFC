package com.example.nextreptfc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nextreptfc.Vistas.Bienvenida
import com.example.nextreptfc.Vistas.IniciarSesion
import com.example.nextreptfc.Vistas.Perfil
import com.example.nextreptfc.Vistas.Registro
import com.example.nextreptfc.ui.theme.NextRepTFCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NextRepTFCTheme {
                Main()
            }
        }
    }
}


@Composable
fun Main() {
    val navController = rememberNavController();

    // Te dice en que pantalla estas actualmente (Es como un GPS)
    val rutaActual = navController.currentBackStackEntryAsState().value?.destination?.route

    // Scaffold
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        // El Bottom bar se mostrara en todas las pantallas menos el de bienvenida, registro e inicio de sesión
        bottomBar = {
            if(rutaActual != "bienvenida" && rutaActual != "registro" && rutaActual != "iniciosesion")
            BarraNavegacionInferior()
        }
    ) { innerPadding ->

        // Ventana de comienzo
        //initialState.destination.route: Es la pantalla de origen (de dónde vienes).
        //targetState.destination.route: Es la pantalla de destino (a dónde vas).
        NavHost(
            navController = navController,
            startDestination = "bienvenida",
            modifier = Modifier.padding(innerPadding),

            // Animación entrada
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight }, // Empieza fuera de pantalla (abajo)
                    animationSpec = tween(500)  // Medio segundo de animación
                ) + fadeIn(animationSpec = tween(500))
            },

            // Animaciñon salida
            exitTransition = {
                fadeOut(animationSpec = tween(500))
            }
        ) {
            composable("bienvenida") { Bienvenida(cambiarVistaRegistro = {navController.navigate("registro")}) }
            composable("registro") { Registro(irAIniciarSesion = {navController.navigate("iniciarsesion")}, irAPerfil = {navController.navigate("perfil")}) }
            composable("iniciarsesion") { IniciarSesion(irARegistro = {navController.navigate("registro")}, irAPerfil = {navController.navigate("perfil")}) }
            composable("perfil") { Perfil() }

        }


    }

}


@Composable
fun BarraNavegacionInferior() {

}