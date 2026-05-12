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