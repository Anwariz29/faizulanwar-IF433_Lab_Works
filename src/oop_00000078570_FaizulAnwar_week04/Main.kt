package oop_00000078570_FaizulAnwar_week04

fun main() {
    println("--- Testing Vehicle ---")
    val generalVehicle = Vehicle("Sepeda Onthel")
    generalVehicle.honk()
    generalVehicle.accelerate()

    println("\n--- Testing Car ---")
    val myCar = Car("Toyota", 4)
    myCar.openTrunk()
    myCar.honk()
    myCar.accelerate()

    println("\n-- Testing Electric Car --")
    val myElectricCar = ElectricCar("Tesla", 4, 85)
    myElectricCar.accelerate()
    myElectricCar.honk()
    myElectricCar.openTrunk()

    println("\n-- Testing Manager --")
    val manager = Manager("Budi", 10_000_000)
    manager.work()
    println("Bonus Manager: Rp ${manager.calculateBonus()}")

    println("\n-- Testing Developer --")
    val developer = Developer("Andi", 8_000_000, "Kotlin")
    developer.work()
    println("Bonus Developer: Rp ${developer.calculateBonus()}")
}