package com.example.nextreptfc.Modelo.Modelos

enum class NivelActividad(val titulo: String, val descripcion: String, val multiplicador: Double) {
    SEDENTARIO("Sedentario", "Poco o ningún ejercicio, trabajo de oficina.", 1.2),
    LIGERO("Ligeramente Activo", "Ejercicio ligero 1-3 días a la semana.", 1.375),
    MODERADO("Moderadamente Activo", "Ejercicio moderado 3-5 días a la semana.", 1.55),
    INTENSO("Muy Activo", "Ejercicio intenso 6-7 días a la semana.", 1.725),
    EXTREMO("Extremadamente Activo", "Trabajo muy físico o doble entrenamiento.", 1.9)
}