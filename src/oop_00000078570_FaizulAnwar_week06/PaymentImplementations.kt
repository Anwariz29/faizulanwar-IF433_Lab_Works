package oop_00000078570_FaizulAnwar_week06


class Gopay : PaymentMethod {
    override fun pay(amount: Double) {
        println("Processing Rp$amount via Gopay Server")
    }
}

class CreditCard : PaymentMethod {
    override fun pay(amount: Double) {
        println("Contactiong Bank for Rp$amount")
    }
}