package oop_00000078570_FaizulAnwar_week05

class EWallet(
    accountName: String,
    var balance: Double
) : PaymentMethod(accountName) {

    // Override abstract function
    override fun processPayment(amount: Double) {
        if (balance >= amount) {
            balance -= amount
            println("Pembayaran berhasil sebesar $amount")
            println("Sisa saldo: $balance")
        } else {
            println("Saldo tidak cukup")
        }
    }

    // Fungsi khusus EWallet
    fun topUp(amount: Double) {
        balance += amount
        println("Top up berhasil sebesar $amount")
        println("Saldo sekarang: $balance")
    }
}