package oop_00000078570_FaizulAnwar_week11

fun main() {
    // Inisialisasi penampung perangkat menggunakan MutableList
    val homeDevices = mutableListOf<SmartDevice>()

    println("Sistem Smart Home telah diinisialisasi.")
    println("Jumlah perangkat saat ini: ${homeDevices.size}")

    val smartLamp = SmartDevice("", "").apply {
        // apply digunakan untuk mengatur properti di dalam lingkup objek tersebut
        name = "Philips WiZ Living Room"
        category = "Lighting"
        isOnline = true
        powerLoad = 12
    }.also {
        // also digunakan untuk melakukan aksi tambahan (menambahkan ke list)
        // setelah konfigurasi selesai
        homeDevices.add(it)
        println("Sistem: Perangkat '${it.name}' berhasil ditambahkan ke list.")
    }

    // Mari kita cek isinya menggunakan fungsi diagnose() yang sudah dibuat sebelumnya
    println("\n--- Status Perangkat Saat Ini ---")
    homeDevices.forEach {
        println(it.diagnose())
    }
}