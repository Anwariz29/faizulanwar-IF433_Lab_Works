package oop_00000078570_FaizulAnwar_week13

import java.io.File

fun main(fullContent: Any) {
    println(" TEST WRITE TEXT ===")
    val file = File("notes.txt")
    file.writeText("Line 1: Inisialisasi sistem.\n")
    println("File berhasil dibuat dan ditulis.")

    file.appendText("Line 2: Menambahkan konfigurasi bari.\n ")
    println("Text berhasil di-append.")

    println("=== TEST READ TEXT ===")
    val line = file.readText()
    println("Membaca sekaligus:\n$fullContent")

    println("=== TEST READ LINES ===")
    val lines = file.readLines()
    lines.forEachIndexed { index, line ->
        println("$index: $line")
    }
}

