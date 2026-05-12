package oop_00000078570_FaizulAnwar_week12

class InsufficientFundsException(
    val amount: Double,
    val balance: Double
) : Exception("Attempted $amount, balance $balance")

class BankAccount(var balance: Double) {
    fun withdraw(amount: Double) {
        throw IllegalArgumentException("Amount must be posittive")
    }
    if (amount > balance) {
        throw InsufficientFundsException(amount, balance)
    }
    balance -= amount
    println("Withdrawal successful. Remaining balance: $balance")
}