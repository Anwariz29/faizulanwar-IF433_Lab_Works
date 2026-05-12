package oop_00000078570_FaizulAnwar_week12

fun dispenseKibble(
    requestedGram: Int,
    availableGram: Int,
    isJammed: Boolean
): Int {

    // validasi input
    require(requestedGram > 0) {
        "Porsi kibble harus lebih dari 0 gr"
    }

    // cek dispenser macet
    if (isJammed) {
        throw DispenserJamException()
    }

    // cek stok cukup atau tidak
    if (requestedGram > availableGram) {
        throw FoodEmptyException(requestedGram, availableGram)
    }

    // hitung sisa stok
    val remainingStock = availableGram - requestedGram

    println("Dispense berhasil! Sisa stok: $remainingStock gr")

    return remainingStock
}

fun main() {

    try {

        val sisa = dispenseKibble(
            requestedGram = 300,
            availableGram = 500,
            isJammed = false
        )

        println("Sisa akhir: $sisa gr")

    } catch (e: FeederException) {

        println("Feeder Error: ${e.message}")

    } catch (e: IllegalArgumentException) {

        println("Input Error: ${e.message}")
    }
}