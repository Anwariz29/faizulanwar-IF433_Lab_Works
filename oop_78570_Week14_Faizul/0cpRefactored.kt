package oop_78570_Week14_Faizul

interface DiscountStrategy {
    fun apply(price: Double): Double
}

class StudentDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.80
}

class MemberDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.85
}

class SaferDiscountCalculator(private val strategy: DiscountStrategy) {
    fun calculate(price: Double) = strategy.apply(price)
}

class SeniorDiscount : DiscountStrategy {
    override fun apply(price: Double) = price * 0.75
}

// === TAMBAHKAN KODE DI BAWAH INI ===
fun main() {
    val hargaAwal = 100000.0

    // Test menggunakan Diskon Mahasiswa
    val kalkulatorSiswa = SaferDiscountCalculator(StudentDiscount())
    val hargaSiswa = kalkulatorSiswa.calculate(hargaAwal)
    println("Harga setelah diskon siswa: Rp $hargaSiswa")

    // Test menggunakan Diskon Senior
    val kalkulatorSenior = SaferDiscountCalculator(SeniorDiscount())
    val hargaSenior = kalkulatorSenior.calculate(hargaAwal)
    println("Harga setelah diskon senior: Rp $hargaSenior")
}