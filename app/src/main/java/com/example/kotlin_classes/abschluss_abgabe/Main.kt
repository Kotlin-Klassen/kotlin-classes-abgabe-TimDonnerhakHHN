package com.example.kotlin_classes.abschluss_abgabe

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kotlin_classes.abschluss_abgabe.library.Library
import com.example.kotlin_classes.abschluss_abgabe.model.Book
import com.example.kotlin_classes.abschluss_abgabe.model.Genre
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    // Bibliotheksadresse erstellen
    val libraryAddress = Library.LibraryAddress(
        "Neckargartacherstr. 42",
        "Heilbronn",
        "74072"
    )

    // Bibliothek erstellen
    val library = Library("Stadtbibliothek Heilbronn", libraryAddress)

    // Bücher erstellen
    val book1 = Book(title = "1984", author = "George Orwell", genre = Genre.FICTION)
    val book2 = Book(title = "Eine kurze Geschichte der Zeit", author = "Stephen Hawking", genre = Genre.SCIENCE)
    val book3 = Book(title = "Die Odyssee", author = "Homer", genre = Genre.HISTORY)

    // Bücher zur Bibliothek hinzufügen
    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)

    // Bibliotheksmitglied über die Library erstellen
    val member = library.LibraryMember(name = "Max Mustermann")

    // Buchaktionen demonstrieren
    member.checkoutBook(book1, LocalDate.now().plusWeeks(3))
    member.reserveBook(book2)

    // Bibliotheksinformationen ausgeben
    library.printLibraryAddress()
    library.displayBookStatuses()

    // Suche demonstrieren
    println("\nSuche nach Büchern:")
    library.searchByTitle("Die").forEach {
        println("${it.title} von ${it.author}")
    }
}
