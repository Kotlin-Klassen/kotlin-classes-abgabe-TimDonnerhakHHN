package com.example.kotlin_classes.abschluss_abgabe.library


import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kotlin_classes.abschluss_abgabe.model.Book
import com.example.kotlin_classes.abschluss_abgabe.model.BookStatus
import java.time.LocalDate

/**
 * Klasse zur Verwaltung einer Bibliothek
 * @param name Name der Bibliothek
 * @param address Adresse der Bibliothek
 */
class Library(
    val name: String,
    private val address: LibraryAddress
) {
    /**
     * Interne Liste der Bücher
     */
    private val books = mutableListOf<Book>()

    /**
     * Fügt ein Buch zur Bibliothek hinzu
     * @param book Hinzuzufügendes Buch
     */
    fun addBook(book: Book) {
        books.add(book)
    }

    /**
     * Sucht Bücher nach Titel
     * @param title Gesuchter Titel
     * @return Liste der gefundenen Bücher
     */
    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, ignoreCase = true) }
    }

    /**
     * Sucht Bücher nach Autor
     * @param author Gesuchter Autor
     * @return Liste der gefundenen Bücher
     */
    fun searchByAuthor(author: String): List<Book> {
        return books.filter { it.author.contains(author, ignoreCase = true) }
    }

    /**
     * Zeigt den Status aller Bücher an
     */
    fun displayBookStatuses() {
        println("Bücher Status:")
        books.forEach { book ->
            println("${book.title} von ${book.author}: ${book.status.getStatusDescription()}")
        }
    }

    /**
     * Gibt die Adresse der Bibliothek aus
     */
    fun printLibraryAddress() {
        address.printAddress()
    }

    /**
     * Nested Klasse für die Bibliotheksadresse
     */
    data class LibraryAddress(
        private val street: String,
        private val city: String,
        private val zipCode: String
    ) {
        /**
         * Druckt die vollständige Adresse
         */
        fun printAddress() {
            println("Bibliotheksadresse: $street, $zipCode $city")
        }
    }

    /**
     * Inner Class für Bibliotheksmitglieder
     */
    inner class LibraryMember(
        val name: String,
    ) {
        /**
         * Leiht ein Buch aus
         * @param book Auszuleihendes Buch
         * @param dueDate Rückgabedatum
         */
        @RequiresApi(Build.VERSION_CODES.O)
        fun checkoutBook(book: Book, dueDate: LocalDate = LocalDate.now().plusWeeks(2)) {
            book.status = BookStatus.CheckedOut(dueDate)
            println("$name hat das Buch '${book.title}' bis $dueDate ausgeliehen.")
        }

        /**
         * Reserviert ein Buch
         * @param book Zu reservierendes Buch
         */
        fun reserveBook(book: Book) {
            book.status = BookStatus.Reserved(name)
            println("$name hat das Buch '${book.title}' reserviert.")
        }

        /**
         * Gibt ein Buch zurück
         * @param book Zurückzugebendes Buch
         */
        fun returnBook(book: Book) {
            book.status = BookStatus.Available
            println("$name hat das Buch '${book.title}' zurückgegeben.")
        }
    }
}