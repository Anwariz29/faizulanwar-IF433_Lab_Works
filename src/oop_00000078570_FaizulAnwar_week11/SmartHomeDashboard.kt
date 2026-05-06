package oop_00000078570_FaizulAnwar_week11

fun main() {
    // 1. Inisialisasi Penampung
    val homeDevices = mutableListOf<SmartDevice>()

    // 2. Konfigurasi Pencahayaan (apply & also)
    SmartDevice("", "").apply {
        name = "Philips WiZ Living Room"
        category = "Lighting"
        isOnline = true
        powerLoad = 12
    }.also {
        homeDevices.add(it)
    }

    // 3. Konfigurasi Keamanan (also & chaining)
    SmartDevice("Ezviz Outdoor", "Camera").apply {
        isOnline = true
        powerLoad = 5
    }.also {
        println("(LOG) Kamera terhubung")
        homeDevices.add(it)
    }

    // 4. Konfigurasi AC & Kabel (run)
    val acInverter = run {
        val device = SmartDevice("Daikin Inverter (Kabel 3x2.5)", "HVAC", false, 800)
        device
    }
    homeDevices.add(acInverter)

    // 5. Tambah Alat Pakan Peliharaan
    homeDevices.add(SmartDevice("Picolo's Auto Feeder", "Pet Care", true, 10))

    // 6. Pencarian Aman (let)
    val searchResult = homeDevices.find { it.category == "Camera" }
    println("\n--- Hasil Pencarian ---")
    searchResult?.let {
        println(it.diagnose())
    }

    // 7. Eksekusi Dashboard (forEach & Extension Function)
    println("\n--- Daftar Seluruh Perangkat (Dashboard) ---")
    homeDevices.forEach { device ->
        println(device.diagnose())
    }

    // 8. Kalkulasi Daya (run)
    val totalPower = homeDevices.run { sumOf { it.powerLoad } }

    // 9. Format Summary (with)
    with(homeDevices) {
        println("\n--- Rangkuman Sistem ---")
        println("Total perangkat : ${this.size} unit")
        println("Total beban daya: $totalPower Watt")
        println("Status Dashboard: Berjalan Normal")
    }
}