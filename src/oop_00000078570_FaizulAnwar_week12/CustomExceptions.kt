package oop_00000078570_FaizulAnwar_week12

class InsufficientFundsException(
    val amount: Double,
    val balance: Double
) : Exception("Attempted $amount, balance $balance")

class BankAccount(var balance: Double) {

    fun withdraw(amount: Double) {

        // cek amount harus positif
        if (amount <= 0) {
            throw IllegalArgumentException("Amount must be positive")
        }

        // cek saldo cukup atau tidak
        if (amount > balance) {
            throw InsufficientFundsException(amount, balance)
        }

        // proses penarikan
        balance -= amount
        println("Withdrawal successful. Remaining balance: $balance")
    }
}

fun main() {

    println("=== TEST MULTIPLE CATCH ===")

    val account = BankAccount(100.0)

    try {
        account.withdraw(150.0)

    } catch (e: InsufficientFundsException) {
        println("Caught Domain Error: Uang tidak cukup. ${e.message}")

    } catch (e: IllegalArgumentException) {
        println("Caught Argument Error: Input tidak valid. ${e.message}")

    } catch (e: Exception) {
        println("Caught General Error: Terjadi kesalahan tidak terduga")
    }
}