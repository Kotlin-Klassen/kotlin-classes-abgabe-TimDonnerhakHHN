package com.example.kotlin_classes.abschluss_abgabe.model


/**
 * Datenklasse zur Repräsentation eines Buches
 * @param title Titel des Buches
 * @param author Autor des Buches
 * @param genre Genre des Buches
 * @param status Aktueller Status des Buches
 */
data class Book(
    val title: String,
    val author: String,
    val genre: Genre,
    var status: BookStatus = BookStatus.Available
)
