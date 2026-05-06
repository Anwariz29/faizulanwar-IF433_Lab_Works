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

    SmartDevice("Ezviz Outdoor", "Camera").apply {
        isOnline = true
        powerLoad = 5
    }.also {
        println("(LOG) Kamera terhubung")
        homeDevices.add(it)
    }

    val acInverter = run {
        val device = SmartDevice("Daikin Inverter (Kabel 3x2.5)", "HVAC", false, 800)
        // Objek ini dikembalikan (return) untuk ditangkap oleh variabel acInverter
        device
    }
    homeDevices.add(acInverter)

    // 4. Konfigurasi Alat Pakan Peliharaan
    homeDevices.add(SmartDevice("Picolo's Auto Feeder", "Pet Care", true, 10))

    println("\n--- Hasil Pencarian Aman ---")

    // 1. Mencari perangkat dengan kategori "Camera"
    val searchResult = homeDevices.find { it.category == "Camera" }

    // 2. Menggunakan ?.let untuk menangani hasil pencarian secara aman
    searchResult?.let {
        // Blok ini hanya akan dijalankan jika searchResult TIDAK null
        println("Hasil ditemukan:")
        println(it.diagnose())
    } ?: println("Pencarian Selesai: Perangkat tidak ditemukan.")

    // Mari kita cek isinya menggunakan fungsi diagnose() yang sudah dibuat sebelumnya
    println("\n--- Status Perangkat Saat Ini ---")
    homeDevices.forEach {
        println(it.diagnose())
    }

}