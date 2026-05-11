package oop_00000078570_FaizulAnwar_week02

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("--- APLIKASI PMB UMN ---")

    print("Masukkan Nama: ")
    val name = scanner.nextLine()

    print("Masukkan NIM (wajib 5 karakter): ")
    val nim = scanner.next()

    scanner.nextLine()

    if (nim.length != 5) {
        println("ERROR: pendaftaran dibatalkan. NIM harus 5 karakter.")
    } else{
        print("Masukkan Jurusan: ")
        val major =  scanner.nextLine()

        val s1 = Student(name, nim, major)
        println("Status: Pendaftaran Selesai.")
    }

    //Secondary Constructor
    // wajib memanggil primary constructor menggunakan 'this()'
    //constructor(name: String, nim: String) : this(name, nim, major = "Non-Matriculated") {
    //    println("LOG: Menggunakan constructor jalur umum (Tanpa Jurusan).")
    //}
}