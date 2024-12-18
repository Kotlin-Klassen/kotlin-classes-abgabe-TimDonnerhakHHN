package com.example.kotlin_classes.abschluss_abgabe.model

import java.time.LocalDate

/**
 * Versiegelte Klasse zur Darstellung des Buchstatus
 */
sealed class BookStatus {
    /**
     * Status: Buch ist verfügbar
     */
    object Available : BookStatus() {
        override fun getStatusDescription() = "Buch ist verfügbar"
    }

    /**
     * Status: Buch ist ausgeliehen
     * @param dueDate Rückgabedatum
     */
    data class CheckedOut(val dueDate: LocalDate) : BookStatus() {
        override fun getStatusDescription() = "Buch ist ausgeliehen bis $dueDate"
    }

    /**
     * Status: Buch ist reserviert
     * @param reservedBy Name des Mitglieds, das das Buch reserviert hat
     */
    data class Reserved(val reservedBy: String) : BookStatus() {
        override fun getStatusDescription() = "Buch ist reserviert von $reservedBy"
    }

    /**
     * Gibt eine lesbare Beschreibung des Buchstatus zurück
     */
    abstract fun getStatusDescription(): String
}
