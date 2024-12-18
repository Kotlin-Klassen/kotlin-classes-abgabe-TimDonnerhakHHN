package com.example.kotlin_classes.abschluss_abgabe.model


/**
 * Enum repräsentiert verschiedene Buchgenres mit Beschreibungen
 */
enum class Genre(val description: String) {
    FICTION("Fiktionale Geschichten und Romane"),
    NON_FICTION("Sachbücher und informative Literatur"),
    SCIENCE("Wissenschaftliche und technische Literatur"),
    HISTORY("Historische Abhandlungen und Forschung"),
    CHILDREN("Kinderbücher");

    /**
     * Gibt die Beschreibung des Genres aus
     */
    fun printDescription() {
        println("Genre: $name - $description")
    }
}
