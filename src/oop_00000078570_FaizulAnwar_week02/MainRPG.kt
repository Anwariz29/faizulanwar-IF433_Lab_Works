package oop_00000078570_FaizulAnwar_week02

import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)

    println("--- MINI RPG BATTLE ---")

    // 1. Input Hero
    print("Masukkan Nama Hero: ")
    val heroName = scanner.nextLine()

    print("Masukkan Base Damage Hero: ")
    val heroDamage = scanner.nextInt()

    val hero = Hero(heroName, heroDamage)

    // 2. Enemy hanya variabel
    var enemyHp = 100

    println("\nMusuh muncul dengan HP: $enemyHp")
    println("${hero.name} HP: ${hero.hp}")

    // 3. Main Loop
    while (hero.isAlive() && enemyHp > 0) {

        println("\n=== MENU ===")
        println("1. Serang")
        println("2. Kabur")
        print("Pilih aksi: ")

        val choice = scanner.nextInt()

        if (choice == 1) {

            // Hero menyerang
            hero.attack("Musuh")
            enemyHp -= hero.baseDamage

            if (enemyHp < 0) {
                enemyHp = 0
            }

            println("Sisa HP Musuh: $enemyHp")

            // Jika musuh masih hidup, dia balas
            if (enemyHp > 0) {
                val enemyDamage = (10..20).random()
                println("Musuh membalas dan memberikan $enemyDamage damage!")
                hero.takeDamage(enemyDamage)
                println("Sisa HP ${hero.name}: ${hero.hp}")
            }

        } else if (choice == 2) {
            println("${hero.name} kabur dari pertarungan!")
            break
        } else {
            println("Pilihan tidak valid!")
        }
    }

    // 4. Pengumuman pemenang
    println("\n=== HASIL PERTARUNGAN ===")

    if (hero.hp > 0 && enemyHp == 0) {
        println("${hero.name} MENANG!")
    } else if (hero.hp == 0 && enemyHp > 0) {
        println("Musuh MENANG!")
    } else {
        println("Pertarungan berakhir tanpa pemenang.")
    }
}