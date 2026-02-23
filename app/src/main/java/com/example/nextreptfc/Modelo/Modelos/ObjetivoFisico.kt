package com.example.nextreptfc.Modelo.Modelos

enum class ObjetivoFisico(val titulo: String, val descripcion: String, val ajusteCalorias: Int, val multiplicadorProteina: Double) {
    PERDER_GRASA("Perder Grasa", "Déficit calórico para reducir grasa manteniendo el músculo.", -500, 2.2),
    GANAR_MUSCULO("Ganar Músculo", "Superávit calórico enfocado en el crecimiento muscular.", 400, 2.0),
    GANAR_FUERZA("Ganar Fuerza", "Ligero superávit para maximizar el peso levantado.", 150, 1.8),
    MANTENIMIENTO("Mantenimiento", "Consumo equilibrado para mantener el peso o recomposición.", 0, 1.8)
}