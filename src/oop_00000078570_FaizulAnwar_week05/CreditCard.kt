package oop_00000078570_FaizulAnwar_week05

class CreditCard(
    accountName: String,
    val limit: Double
) : PaymentMethod(accountName) {

    var usedAmount: Double = 0.0

    override fun processPayment(amount: Double) {
        if (usedAmount + amount <= limit) {
            usedAmount += amount
            println("Transaksi berhasil sebesar $amount")
            println("Total penggunaan kartu: $usedAmount")
            println("Sisa limit: ${limit - usedAmount}")
        } else {
            println("Transaksi ditolak: Melebihi limit kartu")
        }
    }
}