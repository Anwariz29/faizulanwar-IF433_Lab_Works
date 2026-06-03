package oop_00000078570_FaizulAnwar_week12

// Parent Exception
sealed class FeederException(msg: String) : Exception(msg)

// Child Exceptions
class InvalidFoodException :
    FeederException("Makanan yang diberikan tidak valid")

class OverfeedException :
    FeederException("Hewan sudah terlalu kenyang")

class EmptyFoodStockException :
    FeederException("Stok makanan habis")

// Custom Exception 1
class FoodEmptyException(
    requested: Int,
    available: Int
) : FeederException(
    "Kibble tidak cukup! Diminta $requested gr, sisa $available gr"
)

// Custom Exception 2
class DispenserJamException :
    FeederException("Wadah dispenser tersangkut/macet!")

fun dispenseFood(requested: Int, available: Int) {

    if (requested > available) {
        throw FoodEmptyException(requested, available)
    }

    // simulasi dispenser macet
    throw DispenserJamException()
}

fun main() {

    try {
        dispenseFood(500, 200)

    } catch (e: FeederException) {
        println("Error: ${e.message}")
    }
}
