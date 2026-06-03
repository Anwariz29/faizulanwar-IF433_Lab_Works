package oop_00000078570_FaizulAnwar_week02

class Loan(
    val bookTitle: String,
    val borrower: String,
    val loanDuration: Int = 1   // default 1 hari
) {

    fun calculateFine(): Int {
        return if (loanDuration > 3) {
            (loanDuration - 3) * 2000
        } else {
            0
        }
    }
}