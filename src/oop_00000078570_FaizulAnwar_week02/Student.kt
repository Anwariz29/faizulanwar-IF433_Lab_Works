package oop_00000078570_FaizulAnwar_week02

class Student(val name: String, val nim: String, var major: String) {
    var gpa: Double = 0.0

    // Secondary Constructor untuk jalur umum
    constructor(name: String, nim: String) : this(name, nim, "Non-Matriculated") {
        println("LOG: Menggunakan constructor jalur umum (Tanpa Jurusan).")
    }

    fun displayStatus() {
        println("\n--- Detail Pendaftaran ---")
        println("Nama       : $name")
        println("NIM        : $nim")
        println("Jurusan    : $major")
        println("GPA Awal   : $gpa")
        println("--------------------------")
    }
}