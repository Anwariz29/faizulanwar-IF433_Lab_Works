package oop_00000078570_FaizulAnwar_week13

import java.io.File

fun main() {
    println(" TEST WRITE TEXT ===")
    val file = File("notes.txt")
    file.writeText("Line 1: Inisialisasi sistem.\n")
    println("File berhasil dibuat dan ditulis.")

    file.appendText("Line 2: Menambahkan konfigurasi bari.\n ")
    println("Text berhasil di-append.")
}
