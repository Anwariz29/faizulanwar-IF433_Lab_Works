package oop_00000078570_FaizulAnwar_week03

class Employee(val name: String) {

    // Properti dengan Custom Setter
    var salary: Int = 0
        set(value) {
            if (value < 0) {
                println("ERROR: Gaji tidak boleh negatif! Di-set ke 0.")
                field = 0
            } else {
                field = value
            }
        }

    // Properti privat agar tidak bisa diubah sembarangan dari luar
    private var performanceRating: Int = 3

    // Method untuk menaikkan performa
    fun increasePerformance() {
        performanceRating++
        println("Kinerja $name meningkat! Rating: $performanceRating")
    }

    // Method untuk mencetak status
    fun printStatus() {
        println("Karyawan: $name, Gaji: $salary, Rating: $performanceRating")
    }

    val tax: Double
        get() = salary * 0.1
}
