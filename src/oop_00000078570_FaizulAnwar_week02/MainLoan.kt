package oop_00000078570_FaizulAnwar_week02

import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)

    println("--- LIBRARY FINE SYSTEM ---")

    print("Masukkan Judul Buku: ")
    val title = scanner.nextLine()

    print("Masukkan Nama Peminjam: ")
    val borrower = scanner.nextLine()

    print("Masukkan Durasi Pinjam (hari): ")
    var duration = scanner.nextInt()

    // Validasi: tidak boleh minus
    if (duration < 0) {
        println("Durasi tidak boleh minus! Diubah menjadi 1 hari.")
        duration = 1
    }

    // Buat object Loan
    val loan = Loan(title, borrower, duration)

    // Print detail peminjaman
    println("\n--- DETAIL PEMINJAMAN ---")
    println("Judul Buku   : ${loan.bookTitle}")
    println("Peminjam     : ${loan.borrower}")
    println("Durasi Pinjam: ${loan.loanDuration} hari")
    println("Total Denda  : Rp ${loan.calculateFine()}")
}