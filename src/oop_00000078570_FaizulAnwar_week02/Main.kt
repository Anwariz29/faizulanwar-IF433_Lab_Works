package oop_00000078570_FaizulAnwar_week02

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("--- APLIKASI PMB UMN ---")

    print("Masukkan Nama: ")
    val name = scanner.nextLine()

    print("Masukkan NIM (wajib 5 karakter): ")
    val nim = scanner.next()
    scanner.nextLine() // Membersihkan buffer

    // Validasi NIM
    if (nim.length != 5) {
        println("ERROR: Pendaftaran dibatalkan. NIM harus tepat 5 karakter.")
        return // Menghentikan eksekusi main
    }

    println("\nPilih Jalur Pendaftaran:")
    println("1. Reguler (Pilih Jurusan)")
    println("2. Umum (Default: Non-Matriculated)")
    print("Pilihan Anda: ")

    val choice = try { scanner.nextInt() } catch (e: Exception) { 0 }
    scanner.nextLine() // Membersihkan buffer

    val student: Student? = when (choice) {
        1 -> {
            print("Masukkan Jurusan: ")
            val major = scanner.nextLine()
            Student(name, nim, major)
        }
        2 -> {
            Student(name, nim)
        }
        else -> {
            println("Pilihan ngawur, pendaftaran batal!")
            null
        }
    }

    // Jika objek student berhasil dibuat, tampilkan statusnya
    student?.let {
        println("\nStatus: Pendaftaran Selesai.")
        it.displayStatus()
    }
}