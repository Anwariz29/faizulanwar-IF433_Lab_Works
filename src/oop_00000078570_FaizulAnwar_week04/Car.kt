package oop_00000078570_FaizulAnwar_week04

open class Car(brand: String, val numberOfDoors: Int) : Vehicle(brand) {

    fun openTrunk() {
        println("Bagasi mobil $brand dengan $numberOfDoors pintu dibuka. ")
    }

    override fun honk() {
        println("TIN TIN! Mobil $brand lewat!")
    }
}